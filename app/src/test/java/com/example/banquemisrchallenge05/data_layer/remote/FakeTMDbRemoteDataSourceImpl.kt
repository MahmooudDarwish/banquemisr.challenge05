package com.example.banquemisrchallenge05.data_layer.remote

import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.constants.APIKeys
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import com.example.banquemisrchallenge05.utils.test_utils.MovieDetailsMockData
import com.example.banquemisrchallenge05.utils.test_utils.MovieMockData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeTMDbRemoteDataSourceImpl : TMDbRemoteDataSource {

    override suspend fun fetchNowPlayingMovies(page: Int): Flow<List<Movie>> {
        if (page < 0 || page > 289) throw IllegalArgumentException("INVALID PAGE")
        val movies = MovieMockData.getMovies(endpoint = APIKeys.NOW_PLAYING_ENDPOINT)
        return flowOf(movies.results)
    }

    override suspend fun fetchPopularMovies(page: Int): Flow<List<Movie>> {
        if (page < 0 || page > 46674) throw IllegalArgumentException("INVALID PAGE")
        val movies = MovieMockData.getMovies(endpoint = APIKeys.POPULAR_ENDPOINT)
        return flowOf(movies.results)
    }

    override suspend fun fetchUpcomingMovies(page: Int): Flow<List<Movie>> {
        if (page < 0 || page > 69) throw IllegalArgumentException("INVALID PAGE")
        val movies = MovieMockData.getMovies(endpoint = APIKeys.UPCOMING_ENDPOINT)
        return flowOf(movies.results)
    }

    override suspend fun fetchMovieDetails(movieId: Int): Flow<MovieDetails> {
        val movieDetails = MovieDetailsMockData.movies.find { it.id == movieId }
            ?: throw IllegalArgumentException("Movie with id $movieId not found")

        return flowOf(movieDetails)
    }


}
