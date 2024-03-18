package com.lime.regioncodeskg.utils

import android.content.res.Resources
import com.lime.regioncodeskg.R
import java.lang.IllegalStateException

class DiplomaticPlatesResolverImpl(private val resources: Resources) : NumericPlatesResolver {

    override fun resolve(numericInput: List<Int>): String {
        if (numericInput.size > 2)
            throw IllegalStateException("Numeric numbers can not be longer then 2 numbers")
        if (numericInput.size < 2)
            return ""

        return resources.getString(R.string.diplomatic_not_defined)
    }

}