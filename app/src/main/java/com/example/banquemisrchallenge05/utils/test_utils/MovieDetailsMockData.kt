package com.example.banquemisrchallenge05.utils.test_utils

import com.example.banquemisrchallenge05.ui.features.movie_details.model.*

object MovieDetailsMockData {

    // Now Playing Movie Details (based on nowPlayingMovie1)
    val nowPlayingMovieDetails = MovieDetails(
        adult = false,
        backdrop_path = "/path/to/backdrop4.jpg",
        belongs_to_collection = null,
        budget = 120000000,
        genres = listOf(
            Genre(id = 28, name = "Action"),
            Genre(id = 53, name = "Thriller")
        ),
        homepage = "https://www.nowplayingmovie1.com",
        id = 101,
        imdb_id = "tt0010101",
        origin_country = listOf("US"),
        original_language = "en",
        original_title = "Now Playing Movie 1",
        overview = "This is a mock overview of now playing movie 1.",
        popularity = 1500.50,
        poster_path = "/path/to/poster4.jpg",
        production_companies = listOf(
            ProductionCompany(
                id = 1,
                logo_path = "/path/to/logo1.png",
                name = "Action Films",
                origin_country = "US"
            )
        ),
        production_countries = listOf(
            ProductionCountry(iso_3166_1 = "US", name = "United States")
        ),
        release_date = "2024-10-20",
        revenue = 400000000,
        runtime = 130,
        spoken_languages = listOf(
            SpokenLanguage(english_name = "English", iso_639_1 = "en", name = "English")
        ),
        status = "Released",
        tagline = "Action-packed entertainment.",
        title = "Now Playing Movie 1",
        video = false,
        vote_average = 9.0,
        vote_count = 1200
    )

    val nowPlayingMovieDetails2 = MovieDetails(
        adult = false,
        backdrop_path = "/path/to/backdrop5.jpg",
        belongs_to_collection = null,
        budget = 95000000,
        genres = listOf(
            Genre(id = 35, name = "Comedy"),
            Genre(id = 18, name = "Drama")
        ),
        homepage = "https://www.nowplayingmovie2.com",
        id = 102,
        imdb_id = "tt0010102",
        origin_country = listOf("US"),
        original_language = "en",
        original_title = "Now Playing Movie 2",
        overview = "This is a mock overview of now playing movie 2.",
        popularity = 1100.40,
        poster_path = "/path/to/poster5.jpg",
        production_companies = listOf(
            ProductionCompany(
                id = 4,
                logo_path = "/path/to/logo4.png",
                name = "Comedy Drama Studios",
                origin_country = "US"
            )
        ),
        production_countries = listOf(
            ProductionCountry(iso_3166_1 = "US", name = "United States")
        ),
        release_date = "2024-09-22",
        revenue = 350000000,
        runtime = 115,
        spoken_languages = listOf(
            SpokenLanguage(english_name = "English", iso_639_1 = "en", name = "English")
        ),
        status = "Released",
        tagline = "A hilarious and touching story.",
        title = "Now Playing Movie 2",
        video = false,
        vote_average = 8.3,
        vote_count = 900
    )

    // Upcoming Movie Details (based on upcomingMovie1)
    val upcomingMovieDetails = MovieDetails(
        adult = false,
        backdrop_path = "/path/to/backdrop6.jpg",
        belongs_to_collection = null,
        budget = 80000000,
        genres = listOf(
            Genre(id = 16, name = "Animation"),
            Genre(id = 10751, name = "Family")
        ),
        homepage = "https://www.upcomingmovie1.com",
        id = 201,
        imdb_id = "tt0020202",
        origin_country = listOf("US"),
        original_language = "en",
        original_title = "Upcoming Movie 1",
        overview = "This is a mock overview of upcoming movie 1.",
        popularity = 850.30,
        poster_path = "/path/to/poster6.jpg",
        production_companies = listOf(
            ProductionCompany(
                id = 2,
                logo_path = "/path/to/logo2.png",
                name = "Family Films",
                origin_country = "US"
            )
        ),
        production_countries = listOf(
            ProductionCountry(iso_3166_1 = "US", name = "United States")
        ),
        release_date = "2024-12-01",
        revenue = 0,  // No revenue yet as it's not released
        runtime = 100,
        spoken_languages = listOf(
            SpokenLanguage(english_name = "English", iso_639_1 = "en", name = "English")
        ),
        status = "Post Production",
        tagline = "A magical family adventure.",
        title = "Upcoming Movie 1",
        video = false,
        vote_average = 7.8,
        vote_count = 700
    )

    val upcomingMovieDetails2 = MovieDetails(
        adult = false,
        backdrop_path = "/path/to/backdrop7.jpg",
        belongs_to_collection = null,
        budget = 60000000,
        genres = listOf(
            Genre(id = 14, name = "Fantasy"),
            Genre(id = 10749, name = "Romance")
        ),
        homepage = "https://www.upcomingmovie2.com",
        id = 202,
        imdb_id = "tt0020202",
        origin_country = listOf("US"),
        original_language = "en",
        original_title = "Upcoming Movie 2",
        overview = "This is a mock overview of upcoming movie 2.",
        popularity = 900.60,
        poster_path = "/path/to/poster7.jpg",
        production_companies = listOf(
            ProductionCompany(
                id = 5,
                logo_path = "/path/to/logo5.png",
                name = "Romantic Fantasy Films",
                origin_country = "US"
            )
        ),
        production_countries = listOf(
            ProductionCountry(iso_3166_1 = "US", name = "United States")
        ),
        release_date = "2024-11-05",
        revenue = 0,  // No revenue yet as it's not released
        runtime = 105,
        spoken_languages = listOf(
            SpokenLanguage(english_name = "English", iso_639_1 = "en", name = "English")
        ),
        status = "Post Production",
        tagline = "A magical love story.",
        title = "Upcoming Movie 2",
        video = false,
        vote_average = 8.1,
        vote_count = 800
    )

    // Popular Movie Details (based on popularMovie1)
    val popularMovieDetails = MovieDetails(
        adult = false,
        backdrop_path = "/path/to/backdrop8.jpg",
        belongs_to_collection = null,
        budget = 150000000,
        genres = listOf(
            Genre(id = 12, name = "Adventure"),
            Genre(id = 28, name = "Action")
        ),
        homepage = "https://www.popularmovie1.com",
        id = 301,
        imdb_id = "tt0030303",
        origin_country = listOf("US"),
        original_language = "en",
        original_title = "Popular Movie 1",
        overview = "This is a mock overview of popular movie 1.",
        popularity = 2000.80,
        poster_path = "/path/to/poster8.jpg",
        production_companies = listOf(
            ProductionCompany(
                id = 3,
                logo_path = "/path/to/logo3.png",
                name = "Adventure Studios",
                origin_country = "US"
            )
        ),
        production_countries = listOf(
            ProductionCountry(iso_3166_1 = "US", name = "United States")
        ),
        release_date = "2024-08-15",
        revenue = 600000000,
        runtime = 140,
        spoken_languages = listOf(
            SpokenLanguage(english_name = "English", iso_639_1 = "en", name = "English")
        ),
        status = "Released",
        tagline = "An epic adventure awaits.",
        title = "Popular Movie 1",
        video = false,
        vote_average = 9.2,
        vote_count = 1400
    )

    val popularMovieDetails2 = MovieDetails(
        adult = false,
        backdrop_path = "/path/to/backdrop9.jpg",
        belongs_to_collection = null,
        budget = 140000000,
        genres = listOf(
            Genre(id = 28, name = "Action"),
            Genre(id = 80, name = "Crime")
        ),
        homepage = "https://www.popularmovie2.com",
        id = 302,
        imdb_id = "tt0030302",
        origin_country = listOf("US"),
        original_language = "en",
        original_title = "Popular Movie 2",
        overview = "This is a mock overview of popular movie 2.",
        popularity = 1850.70,
        poster_path = "/path/to/poster9.jpg",
        production_companies = listOf(
            ProductionCompany(
                id = 6,
                logo_path = "/path/to/logo6.png",
                name = "Crime Action Productions",
                origin_country = "US"
            )
        ),
        production_countries = listOf(
            ProductionCountry(iso_3166_1 = "US", name = "United States")
        ),
        release_date = "2024-07-10",
        revenue = 500000000,
        runtime = 125,
        spoken_languages = listOf(
            SpokenLanguage(english_name = "English", iso_639_1 = "en", name = "English")
        ),
        status = "Released",
        tagline = "An explosive crime saga.",
        title = "Popular Movie 2",
        video = false,
        vote_average = 8.9,
        vote_count = 1300
    )

    val movies = listOf(
        nowPlayingMovieDetails,
        nowPlayingMovieDetails2,
        upcomingMovieDetails,
        upcomingMovieDetails2,
        popularMovieDetails,
        popularMovieDetails2
    )
}
