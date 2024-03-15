package com.lime.regioncodeskg.ui.navigation.keyboards

sealed class KeyType {
    object Number : KeyType()
    object Letter : KeyType()
    object Delete : KeyType()
}