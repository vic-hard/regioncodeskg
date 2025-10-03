package com.lime.regioncodeskg.viewmodel

import com.lime.regioncodeskg.data.repository.InAppReviewCountRepository
import com.lime.regioncodeskg.ui.model.MilitaryNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.utils.MilitaryPlatesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MilitaryNumbersViewModel @Inject constructor(
    private val militaryPlatesResolver: MilitaryPlatesResolver,
    inAppReviewCountRepository: InAppReviewCountRepository
) : BaseNumbersViewModel(inAppReviewCountRepository) {

    private val _state: MutableStateFlow<MilitaryNumbersState> = MutableStateFlow(MilitaryNumbersState())
    val state = _state.asStateFlow()

    fun onKeyboardButtonClick(text: String, keyType: KeyType) {
        when (keyType) {
            KeyType.Delete -> {
                _state.update {
                    it.copy(selectedSymbols = listOf(), combatArm = "")
                }
            }

            else -> {
                if (state.value.selectedSymbols.size <= 1) {
                    _state.update {
                        val list = it.selectedSymbols.toMutableList()
                        list.add(text)
                        it.copy(selectedSymbols = list)
                    }
                }
                val combatArm = militaryPlatesResolver.resolve(state.value.selectedSymbols)
                _state.update {
                    it.copy(combatArm = combatArm)
                }
                validateAndIncreaseInAppUpdateCount(state.value.selectedSymbols)
            }
        }
    }

    private fun validateAndIncreaseInAppUpdateCount(selectedSymbol: List<String>) {
        if (militaryPlatesResolver.isValidNumber(selectedSymbol))
            increaseInAppReviewCount()
    }
}