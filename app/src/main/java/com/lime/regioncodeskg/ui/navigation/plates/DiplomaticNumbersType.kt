package com.lime.regioncodeskg.ui.navigation.plates

sealed class DiplomaticNumbersType {
    object FiveDigitsType : DiplomaticNumbersType()
    object FourDigitsType : DiplomaticNumbersType()
}