package com.example.banquemisrchallenge05.data_layer.remote

import com.example.banquemisrchallenge05.data_layer.remote.tmdb.TMDbAPIServices
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import com.example.banquemisrchallenge05.data_layer.remote.tmdb.TMDbRetrofitHelper
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TMDbRemoteDataSourceImpl private constructor() : TMDbRemoteDataSource {

    private val apiService: TMDbAPIServices = TMDbRetrofitHelper.api


    private val TAG = "EShopRemoteDataSourceImpl"

    companion object {
        @Volatile
        private var instance: TMDbRemoteDataSourceImpl? = null

        fun getInstance(): TMDbRemoteDataSourceImpl {
            return instance ?: synchronized(this) {
                instance ?: TMDbRemoteDataSourceImpl().also { instance = it }
            }
        }
    }

    override suspend fun fetchNowPlayingMovies(page: Int): Flow<List<Movie>> {
        val movies = apiService.fetchNowPlayingMovies(page = page).results

        return flowOf(movies)
    }

    override suspend fun fetchPopularMovies(page: Int): Flow<List<Movie>> {
        val movies = apiService.fetchPopularMovies(page = page).results

        return flowOf(movies)
    }

    override suspend fun fetchUpcomingMovies(page: Int): Flow<List<Movie>> {
        val movies = apiService.fetchUpcomingMovies(page = page).results

        return flowOf(movies)
    }

    override suspend fun fetchMovieDetails(movieId: Int): Flow<MovieDetails> {
        val movie = apiService.fetchMovieDetails(movieId = movieId)
        return flowOf(movie)
    }
}
