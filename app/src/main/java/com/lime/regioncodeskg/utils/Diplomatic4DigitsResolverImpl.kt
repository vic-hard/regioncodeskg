package com.lime.regioncodeskg.utils

import android.content.res.Resources
import com.lime.regioncodeskg.R
import java.lang.IllegalStateException

class Diplomatic4DigitsResolverImpl(private val resources: Resources) : NumericPlatesResolver {

    override fun resolve(numericInput: List<Int>): String {
        if (numericInput.size > 4)
            throw IllegalStateException("Numeric numbers can not be longer then 2 numbers")
        if (numericInput.size < 4)
            return ""

        return when(numericInput.joinToString(separator = "")) {
            "1001" -> resources.getString(R.string.latvia)
            else -> resources.getString(R.string.diplomatic_not_defined)
        }
    }
}