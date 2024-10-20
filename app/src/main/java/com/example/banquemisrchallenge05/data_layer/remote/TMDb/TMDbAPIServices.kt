package com.example.e_store.utils.data_layer.remote.shopify


import com.example.banquemisrchallenge05.utils.constants.APIKeys
import com.example.banquemisrchallenge05.utils.shared_models.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface TMDbAPIServices {
    @GET(APIKeys.NOW_PLAYING_ENDPOINT)
    suspend fun fetchNowPlayingMovies(
        @Query(APIKeys.PAGE_QUERY) page: Int? = APIKeys.PAGE_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MoviesResponse

    @GET(APIKeys.POPULAR_ENDPOINT)
    suspend fun fetchPopularMovies(
        @Query(APIKeys.PAGE_QUERY) page: Int? = APIKeys.PAGE_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MoviesResponse

    @GET(APIKeys.UPCOMING_ENDPOINT)
    suspend fun fetchUpcomingMovies(
        @Query(APIKeys.PAGE_QUERY) page: Int? = APIKeys.PAGE_VALUE,
        @Query(APIKeys.LANGUAGE_QUERY) language: String? = APIKeys.LANGUAGE_VALUE,
    ): MoviesResponse


}


/*
     --url 'https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1' \
     --url 'https://api.themoviedb.org/3/movie/popular?language=en-US&page=1' \
     --url 'https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1' \
     --url 'https://api.themoviedb.org/3/movie/movie_id?language=en-US' \
*/