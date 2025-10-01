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

        return when(numericInput.joinToString(separator = "")) {
            "01" -> resources.getString(R.string.turkey)
            "02" -> resources.getString(R.string.usa)
            "03" -> resources.getString(R.string.china)
            "04" -> resources.getString(R.string.russia)
            "05" -> resources.getString(R.string.germany)
            "06" -> resources.getString(R.string.iran)
            "07" -> resources.getString(R.string.kazakhstan)
            "08" -> resources.getString(R.string.india)
            "09" -> resources.getString(R.string.belarus)
            "10" -> resources.getString(R.string.pakistan)
            "11" -> resources.getString(R.string.uzbekistan)
            "12" -> resources.getString(R.string.ukraine)
            "13" -> resources.getString(R.string.afghanistan)
            "14" -> resources.getString(R.string.tajikistan)
            "15" -> resources.getString(R.string.japan)
            "16" -> resources.getString(R.string.south_korea)
            "17" -> resources.getString(R.string.european_union)
            "18" -> resources.getString(R.string.france)
            "19" -> resources.getString(R.string.azerbaijan)
            "20" -> resources.getString(R.string.saudi_arabia)
            "21" -> resources.getString(R.string.united_kingdom)
            "22" -> resources.getString(R.string.qatar)
            "23" -> resources.getString(R.string.switzerland)
            "24" -> resources.getString(R.string.mongolia)
            "25" -> resources.getString(R.string.turkmenistan)
            "26" -> resources.getString(R.string.hungary)
            "50" -> resources.getString(R.string.ebrd)
            "51" -> resources.getString(R.string.imf)
            "52" -> resources.getString(R.string.world_bank)
            "53" -> resources.getString(R.string.tv_mir)
            "54" -> resources.getString(R.string.swiss_cooperation)
            "55" -> resources.getString(R.string.german_tech)
            "56" -> resources.getString(R.string.iom)
            "57" -> resources.getString(R.string.uk_inter_coop)
            "58" -> resources.getString(R.string.osce)
            "59" -> resources.getString(R.string.children_villages)
            "60" -> resources.getString(R.string.japan_inter_coop)
            "61" -> resources.getString(R.string.adb)
            "62" -> resources.getString(R.string.icrc)
            "63" -> resources.getString(R.string.aga_khan)
            "64" -> resources.getString(R.string.istc)
            "65" -> resources.getString(R.string.ifrc)
            "66" -> resources.getString(R.string.atc)
            "67" -> resources.getString(R.string.edb)
            "68" -> resources.getString(R.string.rkdf)
            else -> resources.getString(R.string.diplomatic_not_defined)
        }
    }

    override fun isValidNumber(numericInput: List<Int>): Boolean {
        if (numericInput.size > 2)
            return false
        if (numericInput.size < 2)
            return false

        return validNumbers.contains(
            numericInput.joinToString(separator = "")
        )
    }

    private val validNumbers = setOf(
        "01", // Turkey
        "02", // The United States of America
        "03", // China
        "04", // Russian Federation
        "05", // Federal Republic of Germany
        "06", // Iran
        "07", // Republic of Kazakhstan
        "08", // Republic of India
        "09", // Republic of Belarus
        "10", // Pakistan
        "11", // Republic of Uzbekistan
        "12", // Ukraine
        "13", // Afghanistan
        "14", // Tajikistan
        "15", // Japan
        "16", // Republic of Korea
        "17", // European Union
        "18", // French Republic
        "19", // Azerbaijan
        "20", // Saudi Arabia
        "21", // United Kingdom
        "22", // Qatar
        "23", // Switzerland
        "24", // Mongolia
        "25", // Turkmenistan
        "26", // Hungary
        "50", // European Bank for Reconstruction and Development (EBRD)
        "51", // International Monetary Fund (IMF)
        "52", // The World Bank
        "53", // International Television and Radio Company "Mir"
        "54", // Swiss Cooperation Office
        "55", // German Society for Technical Cooperation
        "56", // International Organization for Migration (IOM)
        "57", // UK Department for International Cooperation
        "58", // Organization for Security and Co-operation in Europe (OSCE)
        "59", // Public Fund "SOS - Children's Villages"
        "60", // Japan International Cooperation Agency (JICA)
        "61", // Asian Development Bank (ADB)
        "62", // International Committee of the Red Cross (ICRC)
        "63", // Aga Khan Development Network
        "64", // International Science and Technology Center (ISTC)
        "65", // International Federation of Red Cross and Red Crescent Societies (IFRC)
        "66", // CIS Anti-Terrorism Center (ATC)
        "67", // Eurasian Development Bank (EDB)
        "68"  // Russian-Kyrgyz Development Fund (RKDF)
    )

}