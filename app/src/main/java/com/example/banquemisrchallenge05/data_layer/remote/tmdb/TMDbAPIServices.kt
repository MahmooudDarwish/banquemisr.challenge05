package com.example.banquemisrchallenge05.data_layer.remote.tmdb


import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.constants.APIKeys
import com.example.banquemisrchallenge05.utils.shared_models.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

interface TMDbAPIServices {
    @GET(APIKeys.NOW_PLAYING_ENDPOINT)
    suspend fun fetchNowPlayingMovies(
        @Query(APIKeys.API_KEY_QUERY) apiKey: String = APIKeys.API_KEY_VALUE,
        @Query(APIKeys.PAGE_QUERY) page: Int? = APIKeys.PAGE_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MoviesResponse

    @GET(APIKeys.POPULAR_ENDPOINT)
    suspend fun fetchPopularMovies(
        @Query(APIKeys.API_KEY_QUERY) apiKey: String = APIKeys.API_KEY_VALUE,
        @Query(APIKeys.PAGE_QUERY) page: Int? = APIKeys.PAGE_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MoviesResponse

    @GET(APIKeys.UPCOMING_ENDPOINT)
    suspend fun fetchUpcomingMovies(
        @Query(APIKeys.API_KEY_QUERY) apiKey: String = APIKeys.API_KEY_VALUE,
        @Query(APIKeys.PAGE_QUERY) page: Int? = APIKeys.PAGE_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MoviesResponse

    @GET(APIKeys.MOVIE_DETAILS_ENDPOINT)
    suspend fun fetchMovieDetails(
        @Path(APIKeys.MOVIE_ID_PATH) movieId: Int,
        @Query(APIKeys.API_KEY_QUERY) apiKey: String = APIKeys.API_KEY_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MovieDetails


}
