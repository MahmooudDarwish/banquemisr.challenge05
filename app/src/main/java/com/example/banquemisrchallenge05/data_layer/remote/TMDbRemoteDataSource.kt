package com.example.banquemisrchallenge05.data_layer.remote

import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.flow.Flow

interface TMDbRemoteDataSource {
    suspend fun fetchNowPlayingMovies(page: Int): Flow<List<Movie>>
    suspend fun fetchPopularMovies(page: Int): Flow<List<Movie>>
    suspend fun fetchUpcomingMovies(page: Int): Flow<List<Movie>>
    suspend fun fetchMovieDetails(movieId: Int): Flow<MovieDetails>


}