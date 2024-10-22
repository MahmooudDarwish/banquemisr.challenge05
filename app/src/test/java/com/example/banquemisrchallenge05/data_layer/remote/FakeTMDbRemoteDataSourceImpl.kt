package com.example.banquemisrchallenge05.data_layer.remote

import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import com.example.banquemisrchallenge05.utils.test_utils.MovieDetailsMockData
import com.example.banquemisrchallenge05.utils.test_utils.MovieMockData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeTMDbRemoteDataSourceImpl : TMDbRemoteDataSource {

    override suspend fun fetchNowPlayingMovies(page: Int): Flow<List<Movie>> {
        return flowOf(listOf(MovieMockData.nowPlayingMovie1, MovieMockData.nowPlayingMovie2))
    }

    override suspend fun fetchPopularMovies(page: Int): Flow<List<Movie>> {
        return flowOf(listOf(MovieMockData.popularMovie1, MovieMockData.popularMovie2))

    }

    override suspend fun fetchUpcomingMovies(page: Int): Flow<List<Movie>> {
        return flowOf (listOf(MovieMockData.upcomingMovie1, MovieMockData.upcomingMovie2))

    }

    override suspend fun fetchMovieDetails(movieId: Int): Flow<MovieDetails> {
        val movieDetails = MovieDetailsMockData.movies.find { it.id == movieId }
            ?: throw IllegalArgumentException("Movie with id $movieId not found")

        return flowOf(movieDetails)
    }


}
