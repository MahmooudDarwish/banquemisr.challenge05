package com.example.banquemisrchallenge05.data_layer

import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.flow.Flow


class MoviesRepositoryImpl private constructor(
    private var tmdBRemoteDataSource: TMDbRemoteDataSource,
) : MoviesRepository {

    private val TAG = "EShopRepositoryImpl"

    companion object {
        private var instance: MoviesRepositoryImpl? = null
        fun getInstance(
            moviesRemoteDataSource: TMDbRemoteDataSource,
        ): MoviesRepositoryImpl {
            return instance ?: synchronized(this) {
                val temp = MoviesRepositoryImpl(
                    moviesRemoteDataSource
                )
                instance = temp
                temp
            }

        }
    }

    override suspend fun fetchNowPlayingMovies(page: Int): Flow<List<Movie>> {
        return tmdBRemoteDataSource.fetchNowPlayingMovies(page= page)
    }

    override suspend fun fetchPopularMovies(page: Int): Flow<List<Movie>> {
        return tmdBRemoteDataSource.fetchPopularMovies(page= page)
    }

    override suspend fun fetchUpcomingMovies(page: Int): Flow<List<Movie>> {
        return tmdBRemoteDataSource.fetchUpcomingMovies(page= page)
    }
}