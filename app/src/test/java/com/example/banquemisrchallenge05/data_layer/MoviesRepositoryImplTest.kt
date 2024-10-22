package com.example.banquemisrchallenge05.data_layer

import com.example.banquemisrchallenge05.data_layer.remote.FakeTMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import com.example.banquemisrchallenge05.utils.test_utils.MovieDetailsMockData
import com.example.banquemisrchallenge05.utils.test_utils.MovieMockData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class MoviesRepositoryImplTest {
    private lateinit var remoteDataSource: TMDbRemoteDataSource
    private lateinit var repository: MoviesRepository

    @Before
    fun createRepository() {
        remoteDataSource = FakeTMDbRemoteDataSourceImpl()
        repository = MoviesRepositoryImpl.getInstance(remoteDataSource)
    }

    @Test
    fun fetchNowPlayingMovies_returnsCorrectMovies() = runTest {
        // Act: Call the method to be tested
        val moviesFlow = repository.fetchNowPlayingMovies(1)


        // Assert: Check if the result contains the expected mock data
        val moviesList = moviesFlow.first()
        assertEquals(2, moviesList.size)

        // Check if the details of the first movie match
        val nowPlayingMovie1 = moviesList[0]
        assertEquals(MovieMockData.nowPlayingMovie1.id, nowPlayingMovie1.id)
        assertEquals(MovieMockData.nowPlayingMovie1.title, nowPlayingMovie1.title)

        // Check if the details of the second movie match
        val nowPlayingMovie2 = moviesList[1]
        assertEquals(MovieMockData.nowPlayingMovie2.id, nowPlayingMovie2.id)
        assertEquals(MovieMockData.nowPlayingMovie2.title, nowPlayingMovie2.title)
    }
    @Test
    fun fetchNowPlayingMovies_returnsEmptyList() = runTest {
        // Arrange: Modify the Movies to return an empty list for now playing movies
        MovieMockData.nowPlayingMovies.clear()

        // Act: Call the method to be tested
        val moviesFlow = repository.fetchNowPlayingMovies(1)

        // Assert: Check if the result contains an empty list
        val moviesList = moviesFlow.first()
        assertEquals(0, moviesList.size)
    }

    @Test
    fun fetchPopularMovies_returnsCorrectMovies() = runTest {
        // Act: Call the method to be tested
        val moviesFlow = repository.fetchPopularMovies(1)


        // Assert: Check if the result contains the expected mock data
        val moviesList = moviesFlow.first()
        assertEquals(2, moviesList.size)

        // Check if the details of the first movie match
        val nowPlayingMovie1 = moviesList[0]
        assertEquals(MovieMockData.popularMovie1.id, nowPlayingMovie1.id)
        assertEquals(MovieMockData.popularMovie1.title, nowPlayingMovie1.title)

        // Check if the details of the second movie match
        val nowPlayingMovie2 = moviesList[1]
        assertEquals(MovieMockData.popularMovie2.id, nowPlayingMovie2.id)
        assertEquals(MovieMockData.popularMovie2.title, nowPlayingMovie2.title)
    }
    @Test
    fun fetchPopularMovies_returnsEmptyList() = runTest {
        // Arrange: Modify the Movies to return an empty list for popular movies
        MovieMockData.popularMovies.clear()

        // Act: Call the method to be tested
        val moviesFlow = repository.fetchPopularMovies(1)

        // Assert: Check if the result contains an empty list
        val moviesList = moviesFlow.first()
        assertEquals(0, moviesList.size)
    }

    @Test
    fun fetchUpcomingMovies_returnsCorrectMovies() = runTest {
        // Act: Call the method to be tested
        val moviesFlow = repository.fetchUpcomingMovies(1)


        // Assert: Check if the result contains the expected mock data
        val moviesList = moviesFlow.first()
        assertEquals(2, moviesList.size)

        // Check if the details of the first movie match
        val nowPlayingMovie1 = moviesList[0]
        assertEquals(MovieMockData.upcomingMovie1.id, nowPlayingMovie1.id)
        assertEquals(MovieMockData.upcomingMovie1.title, nowPlayingMovie1.title)

        // Check if the details of the second movie match
        val nowPlayingMovie2 = moviesList[1]
        assertEquals(MovieMockData.upcomingMovie2.id, nowPlayingMovie2.id)
        assertEquals(MovieMockData.upcomingMovie2.title, nowPlayingMovie2.title)
    }
    @Test
    fun fetchUpcomingMovies_returnsEmptyList() = runTest {
        // Arrange: Modify the Movies to return an empty list for upcoming movies
        MovieMockData.upcomingMovies.clear()

        // Act: Call the method to be tested
        val moviesFlow = repository.fetchUpcomingMovies(1)

        // Assert: Check if the result contains an empty list
        val moviesList = moviesFlow.first()
        assertEquals(0, moviesList.size)
    }


    @Test
    fun fetchMovieDetails_returnsCorrectDetails_forNowPlayingMovie1() = runTest {
        // Act: Call the method to be tested
        val movieDetailsFlow = repository.fetchMovieDetails(101)

        // Assert: Check if the result matches the expected details for Now Playing Movie 1
        val movieDetails = movieDetailsFlow.first()
        assertEquals(101, movieDetails.id)
        assertEquals(MovieDetailsMockData.nowPlayingMovieDetails.title, movieDetails.original_title)
        assertEquals(MovieDetailsMockData.nowPlayingMovieDetails.overview, movieDetails.overview)
    }

    @Test
    fun fetchMovieDetails_returnsCorrectDetails_forUpcomingMovie2() = runTest {
        // Act: Call the method to be tested
        val movieDetailsFlow = repository.fetchMovieDetails(202)

        // Assert: Check if the result matches the expected details for Upcoming Movie 2
        val movieDetails = movieDetailsFlow.first()
        assertEquals(202, movieDetails.id)
        assertEquals(MovieDetailsMockData.upcomingMovieDetails2.title, movieDetails.original_title)
        assertEquals(MovieDetailsMockData.upcomingMovieDetails2.overview, movieDetails.overview)
    }

    @Test
    fun fetchMovieDetails_returnsCorrectDetails_forPopularMovie1() = runTest {
        // Act: Call the method to be tested
        val movieDetailsFlow = repository.fetchMovieDetails(301)

        // Assert: Check if the result matches the expected details for Popular Movie 1
        val movieDetails = movieDetailsFlow.first()
        assertEquals(301, movieDetails.id)
        assertEquals(MovieDetailsMockData.popularMovieDetails.title, movieDetails.original_title)
        assertEquals(MovieDetailsMockData.popularMovieDetails.overview, movieDetails.overview)
    }

    @Test
    fun fetchMovieDetails_returnsCorrectDetails_forPopularMovie2() = runTest {
        // Act: Call the method to be tested
        val movieDetailsFlow = repository.fetchMovieDetails(302)

        // Assert: Check if the result matches the expected details for Popular Movie 2
        val movieDetails = movieDetailsFlow.first()
        assertEquals(302, movieDetails.id)
        assertEquals(MovieDetailsMockData.popularMovieDetails.title, movieDetails.original_title)
        assertEquals(MovieDetailsMockData.popularMovieDetails.overview, movieDetails.overview)
    }

    @Test(expected = IllegalArgumentException::class)
    fun fetchMovieDetails_throwsException_forInvalidMovieId(): Unit = runTest {
        // Act: Call the coroutine function with an invalid movie ID
        repository.fetchMovieDetails(999).first()
    }


}