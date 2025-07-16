package com.lime.regioncodeskg.viewmodel

import androidx.lifecycle.ViewModel
import com.lime.regioncodeskg.di.qualifiers.NewNumbersResolver
import com.lime.regioncodeskg.ui.model.DefineNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.utils.NumericPlatesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewNumbersViewModel @Inject constructor(
    @NewNumbersResolver private val numericPlatesResolver: NumericPlatesResolver
) : ViewModel() {

    private val _state: MutableStateFlow<DefineNumbersState> = MutableStateFlow(DefineNumbersState())
    val state = _state.asStateFlow()

    fun onKeyboardButtonClick(text: String, keyType: KeyType) {
        when(keyType) {
            KeyType.Delete -> {
                _state.update {
                    it.copy(selectedSymbols = listOf(), regionString = "")
                }
            }
            else -> {
                if (state.value.selectedSymbols.size <= 1) {
                    _state.update {
                        val list = validateNewNumbersText(text)
                        it.copy(selectedSymbols = list)
                    }
                }
                val regionString = numericPlatesResolver.resolve(
                    state.value.selectedSymbols.map { it.toInt() }
                )
                _state.update {
                    it.copy(regionString = regionString)
                }
            }
        }
    }

    private fun validateNewNumbersText(text: String): List<String> {
        return when(text) {
            "0" -> listOf(text)
            "1", "2", "3", "4", "5", "6", "7", "8", "9" -> listOf("0", text)
            else -> throw IllegalStateException("new numbers should have only 1-9")
        }
    }
}