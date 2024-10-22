package com.example.banquemisrchallenge05.utils.test_utils

import com.example.banquemisrchallenge05.utils.constants.APIKeys
import com.example.banquemisrchallenge05.utils.shared_models.Dates
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import com.example.banquemisrchallenge05.utils.shared_models.MoviesResponse

object MovieMockData {

    val mockDates = Dates(
        maximum = "2024-12-31",
        minimum = "2024-01-01"
    )

    // Now Playing Movies
    val nowPlayingMovie1 = Movie(
        adult = false,
        backdrop_path = "/path/to/backdrop4.jpg",
        genre_ids = listOf(28, 53),
        id = 101,
        original_language = "en",
        original_title = "Now Playing Movie 1",
        overview = "This is a mock overview of now playing movie 1.",
        popularity = 1500.50,
        poster_path = "/path/to/poster4.jpg",
        release_date = "2024-10-20",
        title = "Now Playing Movie 1",
        video = false,
        vote_average = 9.0,
        vote_count = 1200
    )

    val nowPlayingMovie2 = Movie(
        adult = false,
        backdrop_path = "/path/to/backdrop5.jpg",
        genre_ids = listOf(35, 18),
        id = 102,
        original_language = "en",
        original_title = "Now Playing Movie 2",
        overview = "This is a mock overview of now playing movie 2.",
        popularity = 1100.40,
        poster_path = "/path/to/poster5.jpg",
        release_date = "2024-09-22",
        title = "Now Playing Movie 2",
        video = false,
        vote_average = 8.3,
        vote_count = 900
    )

    // Upcoming Movies
    val upcomingMovie1 = Movie(
        adult = false,
        backdrop_path = "/path/to/backdrop6.jpg",
        genre_ids = listOf(16, 10751),
        id = 201,
        original_language = "en",
        original_title = "Upcoming Movie 1",
        overview = "This is a mock overview of upcoming movie 1.",
        popularity = 850.30,
        poster_path = "/path/to/poster6.jpg",
        release_date = "2024-12-01",
        title = "Upcoming Movie 1",
        video = false,
        vote_average = 7.8,
        vote_count = 700
    )

    val upcomingMovie2 = Movie(
        adult = false,
        backdrop_path = "/path/to/backdrop7.jpg",
        genre_ids = listOf(14, 10749),
        id = 202,
        original_language = "en",
        original_title = "Upcoming Movie 2",
        overview = "This is a mock overview of upcoming movie 2.",
        popularity = 900.60,
        poster_path = "/path/to/poster7.jpg",
        release_date = "2024-11-05",
        title = "Upcoming Movie 2",
        video = false,
        vote_average = 8.1,
        vote_count = 800
    )

    // Popular Movies
    val popularMovie1 = Movie(
        adult = false,
        backdrop_path = "/path/to/backdrop8.jpg",
        genre_ids = listOf(12, 28),
        id = 301,
        original_language = "en",
        original_title = "Popular Movie 1",
        overview = "This is a mock overview of popular movie 1.",
        popularity = 2000.80,
        poster_path = "/path/to/poster8.jpg",
        release_date = "2024-08-15",
        title = "Popular Movie 1",
        video = false,
        vote_average = 9.2,
        vote_count = 1400
    )

    val popularMovie2 = Movie(
        adult = false,
        backdrop_path = "/path/to/backdrop9.jpg",
        genre_ids = listOf(28, 80),
        id = 302,
        original_language = "en",
        original_title = "Popular Movie 2",
        overview = "This is a mock overview of popular movie 2.",
        popularity = 1850.70,
        poster_path = "/path/to/poster9.jpg",
        release_date = "2024-07-10",
        title = "Popular Movie 2",
        video = false,
        vote_average = 8.9,
        vote_count = 1300
    )

    var nowPlayingMovies = mutableListOf(nowPlayingMovie1, nowPlayingMovie2)
    var upcomingMovies = mutableListOf(upcomingMovie1, upcomingMovie2)
    var popularMovies = mutableListOf(popularMovie1, popularMovie2)


    fun getMovies(endpoint: String): MoviesResponse {
        return when (endpoint) {
            APIKeys.NOW_PLAYING_ENDPOINT -> {
                MoviesResponse(
                    dates = mockDates,
                    page = 1,
                    results = nowPlayingMovies
                )
            }

            APIKeys.UPCOMING_ENDPOINT -> {
                MoviesResponse(
                    dates = mockDates,
                    page = 1,
                    results = upcomingMovies
                )
            }

            APIKeys.POPULAR_ENDPOINT -> {
                MoviesResponse(
                    dates = mockDates,
                    page = 1,
                    results = popularMovies
                )
            }

            else -> {
                throw IllegalArgumentException("Invalid endpoint: $endpoint")
            }
        }
    }

}
