package com.lime.regioncodeskg.utils

import android.content.res.Resources
import com.lime.regioncodeskg.R
import java.lang.IllegalStateException

class MilitaryPlatesResolverImpl(private val resources: Resources) : MilitaryPlatesResolver {

    override fun resolve(input: List<String>): String {
        if (input.size > 2)
            throw IllegalStateException("Military plates can not be longer then 2 symbols")
        if (input.size < 2)
            return ""

        return when(input.joinToString(separator = "")) {
            "КА" -> resources.getString(R.string.ground_forces)
            "КК" -> resources.getString(R.string.armed_forces)
            "КМ" -> resources.getString(R.string.ministry_defence)
            "УГ" -> resources.getString(R.string.national_guard)
            "ЧК" -> resources.getString(R.string.border_guard_service)
            "БА" -> resources.getString(R.string.central_office)
            "АС" -> resources.getString(R.string.military_court)
            "ЖК", "МЮ" -> resources.getString(R.string.ministry_of_justice)
            else -> resources.getString(R.string.combat_arm_not_defined)
        }

    }

    override fun isValidNumber(input: List<String>): Boolean {
        if (input.size != 2)
            return false

        return validMilitaryCodes.contains(
            input.joinToString(separator = "")
        )
    }

    private val validMilitaryCodes = setOf(
        "КА", // Ground Forces
        "КК", // Armed Forces
        "КМ", // Ministry of Defence
        "УГ", // National Guard
        "ЧК", // Border Guard Service
        "БА", // Central Office
        "АС", // Military Court
        "ЖК", // Ministry of Justice
        "МЮ"  // Ministry of Justice
    )

}