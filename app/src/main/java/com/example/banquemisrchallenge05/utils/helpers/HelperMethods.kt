package com.example.banquemisrchallenge05.utils.helpers

fun getMovieImageUrl(posterPath: String): String {
    val baseUrl = "https://image.tmdb.org/t/p/w500"
    return baseUrl + posterPath
}
