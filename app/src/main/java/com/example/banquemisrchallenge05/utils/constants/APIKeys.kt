package com.example.banquemisrchallenge05.utils.constants

object APIKeys {
    // Init setup
    const val TMDB_BASE_URL = "https://api.themoviedb.org/3/movie/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

    //Headers
    const val AUTHORIZATION_HEADER = "Authorization"
    const val API_READ_ACCESS_TOKEN =
        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNTZlZGMwNTIwYTk1ZGY5ZmJkNDgyZGJkM2NmY2VmNyIsIm5iZiI6MTcyOTQzNjc5My44OTgwNzcsInN1YiI6IjY3MTUxYjliMGNiNjI1MmY5OTA4Y2Y5ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.wSx4nFU28FdCknLJRSoGA9ATYwkk5994pstL9rZVMj8"

    //Endpoints
    const val NOW_PLAYING_ENDPOINT = "now_playing"
    const val POPULAR_ENDPOINT = "popular"
    const val UPCOMING_ENDPOINT = "upcoming"
    const val MOVIE_DETAILS_ENDPOINT = "{movie_id}"

    //Path params
    const val MOVIE_ID_PATH = "movie_id"

    //Endpoints Params
    const val API_KEY_QUERY = "api_key"
    const val LANGUAGE_QUERY = "language"
    const val PAGE_QUERY = "page"


    //Values
    const val LANGUAGE_VALUE = "en-US"
    const val PAGE_VALUE = 1
    const val API_KEY_VALUE = "f56edc0520a95df9fbd482dbd3cfcef7"


}

