package com.lime.regioncodeskg.ui.model

import com.lime.regioncodeskg.ui.navigation.plates.DiplomaticNumbersType

data class DiplomaticNumbersState(val selectedSymbols: List<String> = listOf(),
                                  val regionString: String = "",
                                  val showDialog: Boolean = false,
                                  val diplomaticNumbersType: DiplomaticNumbersType
)
