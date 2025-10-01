package com.lime.regioncodeskg.viewmodel

import com.lime.regioncodeskg.data.repository.InAppReviewCountRepository
import com.lime.regioncodeskg.di.qualifiers.Diplomatic4DigitsResolver
import com.lime.regioncodeskg.ui.model.DiplomaticNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.ui.navigation.plates.DiplomaticNumbersType
import com.lime.regioncodeskg.utils.NumericPlatesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class Diplomatic4DigitsViewModel @Inject constructor(
    @Diplomatic4DigitsResolver private val numericPlatesResolver: NumericPlatesResolver,
    inAppReviewCountRepository: InAppReviewCountRepository
) : BaseNumbersViewModel(inAppReviewCountRepository) {

    private val _state: MutableStateFlow<DiplomaticNumbersState> =
        MutableStateFlow(DiplomaticNumbersState(diplomaticNumbersType = DiplomaticNumbersType.FourDigitsType))
    val state = _state.asStateFlow()

    fun onKeyboardButtonClick(text: String, keyType: KeyType) {
        when(keyType) {
            KeyType.Delete -> {
                _state.update {
                    it.copy(selectedSymbols = listOf(), regionString = "")
                }
            }
            else -> {
                if (state.value.selectedSymbols.size <= 3) {
                    _state.update {
                        val list = it.selectedSymbols.toMutableList()
                        list.add(text)
                        it.copy(selectedSymbols = list)
                    }
                }
                val regionString = numericPlatesResolver.resolve(
                    state.value.selectedSymbols.map { it.toInt() }
                )
                _state.update {
                    it.copy(regionString = regionString)
                }
                validateAndIncreaseInAppUpdateCount()
            }
        }
    }

    private fun validateAndIncreaseInAppUpdateCount() {
        val number = state.value.selectedSymbols.map { it.toInt() }
        if (numericPlatesResolver.isValidNumber(number)) {
            increaseInAppReviewCount()
        }
    }

    fun toggleDialog() {
        _state.update {
            it.copy(showDialog = !state.value.showDialog)
        }
    }
}