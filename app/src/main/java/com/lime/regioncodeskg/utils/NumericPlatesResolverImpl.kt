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

        return when(numericInput.joinToString(separator = "")) {
            "01" -> resources.getString(R.string.bishkek)
            "02" -> resources.getString(R.string.osh)
            "03" -> resources.getString(R.string.batken_region)
            "04" -> resources.getString(R.string.jalal_abad_region)
            "05" -> resources.getString(R.string.naryn_region)
            "06" -> resources.getString(R.string.osh_region)
            "07" -> resources.getString(R.string.talas_region)
            "08" -> resources.getString(R.string.chuy_region)
            "09" -> resources.getString(R.string.issyk_kul_region)
            "10" -> resources.getString(R.string.legalized_cars)
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
        "09", // Issyk-Kul Region
        "10"  // Legalized cars
    )
}