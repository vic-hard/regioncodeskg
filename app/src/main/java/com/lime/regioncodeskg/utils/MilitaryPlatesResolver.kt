package com.lime.regioncodeskg.utils

interface MilitaryPlatesResolver {
    fun resolve(input: List<String>): String
    fun isValidNumber(input: List<String>): Boolean
}