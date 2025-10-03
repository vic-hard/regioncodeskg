package com.lime.regioncodeskg.utils

import android.content.res.Resources
import com.lime.regioncodeskg.R
import java.lang.IllegalStateException

class NumericPlatesResolverImpl(private val resources: Resources) : NumericPlatesResolver {

    override fun resolve(numericInput: List<Int>): String {
        if (numericInput.size > 2)
            throw IllegalStateException("Numeric numbers can not be longer then 2 numbers")
        if (numericInput.size < 2)
            return ""
        if (numericInput[0] != 0)
            return resources.getString(R.string.region_not_defined)

        return when(numericInput[1]) {
            1 -> resources.getString(R.string.bishkek)
            2 -> resources.getString(R.string.osh)
            3 -> resources.getString(R.string.batken_region)
            4 -> resources.getString(R.string.jalal_abad_region)
            5 -> resources.getString(R.string.naryn_region)
            6 -> resources.getString(R.string.osh_region)
            7 -> resources.getString(R.string.talas_region)
            8 -> resources.getString(R.string.chuy_region)
            9 -> resources.getString(R.string.issyk_kul_region)
            else -> resources.getString(R.string.region_not_defined)
        }
    }

    override fun isValidNumber(numericInput: List<Int>): Boolean {
        if (numericInput.size != 2)
            return false

        return validNumbers.contains(
            numericInput.joinToString(separator = "")
        )
    }

    private val validNumbers = setOf(
        "01", // Bishkek
        "02", // Osh
        "03", // Batken Region
        "04", // Jalal-Abad Region
        "05", // Naryn Region
        "06", // Osh Region
        "07", // Talas Region
        "08", // Chuy Region
        "09"  // Issyk-Kul Region
    )
}