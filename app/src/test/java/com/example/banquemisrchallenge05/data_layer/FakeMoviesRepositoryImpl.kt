package com.example.banquemisrchallenge05.data_layer

import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.flow.Flow


class FakeMoviesRepositoryImpl(
    private var tmdBRemoteDataSource: TMDbRemoteDataSource,
) : MoviesRepository {

    override suspend fun fetchNowPlayingMovies(page: Int): Flow<List<Movie>> {
        return tmdBRemoteDataSource.fetchNowPlayingMovies(page)
    }

    override suspend fun fetchPopularMovies(page: Int): Flow<List<Movie>> {
        return tmdBRemoteDataSource.fetchPopularMovies(page)
    }

    override suspend fun fetchUpcomingMovies(page: Int): Flow<List<Movie>> {
        return tmdBRemoteDataSource.fetchUpcomingMovies(page)
    }

    override suspend fun fetchMovieDetails(movieId: Int): Flow<MovieDetails> {
        return tmdBRemoteDataSource.fetchMovieDetails(movieId)
    }

}