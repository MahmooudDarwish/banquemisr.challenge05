package com.example.banquemisrchallenge05.ui.features.upcoming.view_model

import com.example.banquemisrchallenge05.data_layer.FakeMoviesRepositoryImpl
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import com.example.banquemisrchallenge05.data_layer.remote.FakeTMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSource
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import com.example.banquemisrchallenge05.utils.test_utils.MovieMockData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UpcomingViewModelTest{
    private lateinit var repository: MoviesRepository
    private lateinit var viewModel: UpcomingViewModel
    private lateinit var remoteDataSource: TMDbRemoteDataSource
    private lateinit var testDispatcher: TestDispatcher


    @Before
    fun setup() {
        testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)

        remoteDataSource = FakeTMDbRemoteDataSourceImpl()
        repository = FakeMoviesRepositoryImpl(
            tmdBRemoteDataSource = remoteDataSource,
        )
        viewModel = UpcomingViewModel(repository = repository, dispatcher = testDispatcher)
    }

    @Test
    fun fetchNowPlayingMovies_returnsCorrectMovies() = runTest {
        // Act: Trigger the ViewModel's function
        viewModel.getUpcomingMovies()

        testDispatcher.scheduler.advanceUntilIdle()

        val upcomingMoviesStates = viewModel.upcomingMovies.value

        // Assert: Check if the state flow has emitted the correct success state
        Assert.assertTrue(upcomingMoviesStates is DataState.Success)
        Assert.assertEquals(
            MovieMockData.upcomingMovies,
            (upcomingMoviesStates as DataState.Success).data
        )
    }


    @Test
    fun fetchNowPlayingMovies_handleErrorCorrectly() = runTest {
        //Act: Set the fake response to throw an error
        viewModel.getUpcomingMovies(page = -500)
        testDispatcher.scheduler.advanceUntilIdle()

        val upcomingMoviesStates = viewModel.upcomingMovies.value


        // Assert: Verify the flow emits loading then error
        Assert.assertEquals(
            2131624064,
            (upcomingMoviesStates as DataState.Error).message
        )

    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}