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
            "1101" -> resources.getString(R.string.hungary)
            "1201" -> resources.getString(R.string.italy)
            "1301" -> resources.getString(R.string.canada)
            "1401" -> resources.getString(R.string.sweden)
            "1501" -> resources.getString(R.string.united_kingdom)
            "1601" -> resources.getString(R.string.cyprus)
            "1701" -> resources.getString(R.string.czech_republic)
            "1801" -> resources.getString(R.string.moldova)
            "1901" -> resources.getString(R.string.slovak_republic)
            "2001" -> resources.getString(R.string.romania)
            "2101" -> resources.getString(R.string.lithuania)
            "2201" -> resources.getString(R.string.netherlands)
            "2301" -> resources.getString(R.string.turkey)
            "2401" -> resources.getString(R.string.belgium)
            "2601" -> resources.getString(R.string.spain)
            "2701" -> resources.getString(R.string.armenia)
            "2801" -> resources.getString(R.string.kz_chuy_ik_naryn)
            "2901" -> resources.getString(R.string.brazil)
            "3001" -> resources.getString(R.string.norway)
            "3101" -> resources.getString(R.string.austria)
            "3201" -> resources.getString(R.string.poland)
            "3301" -> resources.getString(R.string.srilanka)
            "3401" -> resources.getString(R.string.belarus)
            "3501" -> resources.getString(R.string.estonia)
            "3601" -> resources.getString(R.string.indonesia)
            "3701" -> resources.getString(R.string.jordan)
            "3801" -> resources.getString(R.string.bangladesh)
            "3901" -> resources.getString(R.string.fiji)
            "4001" -> resources.getString(R.string.kz_talas)
            else -> resources.getString(R.string.diplomatic_not_defined)
        }
    }
}