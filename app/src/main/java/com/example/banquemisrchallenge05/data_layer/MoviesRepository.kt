package com.example.banquemisrchallenge05.data_layer

import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository : TMDbRemoteDataSource {
}