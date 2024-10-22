package com.example.banquemisrchallenge05.ui.features.movie_details.view_model

import com.example.banquemisrchallenge05.data_layer.FakeMoviesRepositoryImpl
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import com.example.banquemisrchallenge05.data_layer.remote.FakeTMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieDetailsViewModelTest{
    private lateinit var repository: MoviesRepository
    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var remoteDataSource: TMDbRemoteDataSource
    private lateinit var testDispatcher: TestDispatcher

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)
        remoteDataSource = FakeTMDbRemoteDataSourceImpl()
        repository = FakeMoviesRepositoryImpl(
            tmdBRemoteDataSource = remoteDataSource,
        )
        viewModel = MovieDetailsViewModel(repository = repository, dispatcher = testDispatcher)
    }

    @Test
    fun getMovieDetails_Success() = runTest {
        // Act: Call the ViewModel function
        viewModel.getMovieDetails(movieId = 101)
        testDispatcher.scheduler.advanceUntilIdle()
        // Assert: Verify the correct state is emitted
        val movieDetailsState = viewModel.movieDetails.value
        assert(movieDetailsState is DataState.Success)

    }

    @Test
    fun getMovieDetails_handlesErrorCorrectly() = runTest {

        // Act: Call the ViewModel function
        viewModel.getMovieDetails(movieId = 36)

        // Advance time to let the coroutine complete
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert: Verify the error state is emitted
        val movieDetailsState = viewModel.movieDetails.value
        assert(movieDetailsState is DataState.Error)
        assertEquals(2131624064, (movieDetailsState as DataState.Error).message)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}

