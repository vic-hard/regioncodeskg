package com.lime.regioncodeskg.utils

import android.content.res.Resources
import com.lime.regioncodeskg.R

class OldPlatesResolverImpl(private val resources: Resources) : OldPlatesResolver {

    override fun resolve(input: String): String {
        return when(input) {
            "B", "E", "F" -> resources.getString(R.string.bishkek)
            "Z" -> resources.getString(R.string.osh)
            "A" -> resources.getString(R.string.batken_region)
            "D" -> resources.getString(R.string.jalal_abad_region)
            "N", "H" -> resources.getString(R.string.naryn_region)
            "O" -> resources.getString(R.string.osh_region)
            "T" -> resources.getString(R.string.talas_region)
            "C", "S" -> resources.getString(R.string.chuy_region)
            "I" -> resources.getString(R.string.issyk_kul_region)
            else -> resources.getString(R.string.region_not_defined)
        }
    }

}