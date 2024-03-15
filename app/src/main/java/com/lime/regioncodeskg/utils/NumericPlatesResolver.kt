package com.lime.regioncodeskg.utils

interface NumericPlatesResolver {
    fun resolve(numericInput: List<Int>): String
}