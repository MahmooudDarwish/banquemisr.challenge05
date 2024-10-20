package com.example.banquemisrchallenge05.data_layer.remote

import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.flow.Flow

interface TMDbRemoteDataSource {
    suspend fun fetchNowPlayingMovies(): Flow<List<Movie>>

}