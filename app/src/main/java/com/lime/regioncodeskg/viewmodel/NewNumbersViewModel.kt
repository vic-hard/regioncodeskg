package com.lime.regioncodeskg.viewmodel

import androidx.lifecycle.ViewModel
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
    private val numericPlatesResolver: NumericPlatesResolver
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
            }
        }
    }
}