package com.lime.regioncodeskg.viewmodel

import androidx.lifecycle.ViewModel
import com.lime.regioncodeskg.ui.model.OldNumbersState
import com.lime.regioncodeskg.ui.navigation.keyboards.KeyType
import com.lime.regioncodeskg.utils.OldPlatesResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OldNumbersViewModel @Inject constructor(
    private val oldPlatesResolver: OldPlatesResolver
) : ViewModel() {

    private val _state: MutableStateFlow<OldNumbersState> = MutableStateFlow(OldNumbersState())
    val state = _state.asStateFlow()

    fun onKeyboardButtonClick(text: String, keyType: KeyType) {
        when(keyType) {
            KeyType.Delete -> {
                _state.update {
                    it.copy(selectedSymbol = "", regionString = "")
                }
            }
            else -> {
                _state.update {
                    it.copy(selectedSymbol = text)
                }
                val regionString = oldPlatesResolver.resolve(state.value.selectedSymbol)
                _state.update {
                    it.copy(regionString = regionString)
                }
            }
        }
    }
}