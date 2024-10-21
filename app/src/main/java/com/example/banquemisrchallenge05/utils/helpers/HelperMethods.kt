package com.example.banquemisrchallenge05.utils.helpers

import com.example.banquemisrchallenge05.ui.features.movie_details.model.ProductionCountry
import com.example.banquemisrchallenge05.utils.constants.APIKeys

fun getImageUrl(posterPath: String): String {
    return APIKeys.IMAGE_BASE_URL + posterPath
}

fun getCountryFlag(isoCode: String): String {
    return isoCode.uppercase()
        .map { char ->
            Character.toChars(char.code - 65 + 0x1F1E6)
        }
        .joinToString("") { String(it) }
}


fun getAllCountryFlags(countries: List<ProductionCountry>): String {
    return countries.joinToString(", ") { country ->
        "${getCountryFlag(country.iso_3166_1)} ${country.iso_3166_1}"
    }
}
