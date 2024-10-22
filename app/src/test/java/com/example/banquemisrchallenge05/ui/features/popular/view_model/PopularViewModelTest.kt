package com.example.banquemisrchallenge05.ui.features.popular.view_model

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
class PopularViewModelTest {
    private lateinit var repository: MoviesRepository
    private lateinit var viewModel: PopularViewModel
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
        viewModel = PopularViewModel(repository = repository, dispatcher = testDispatcher)
    }

    @Test
    fun fetchNowPlayingMovies_returnsCorrectMovies() = runTest {
        // Act: Trigger the ViewModel's function
        viewModel.getPopularMovies()

        testDispatcher.scheduler.advanceUntilIdle()

        val popularMoviesStates = viewModel.popularMovies.value

        // Assert: Check if the state flow has emitted the correct success state
        Assert.assertTrue(popularMoviesStates is DataState.Success)
        Assert.assertEquals(
            MovieMockData.popularMovies,
            (popularMoviesStates as DataState.Success).data
        )
    }


    @Test
    fun fetchNowPlayingMovies_handleErrorCorrectly() = runTest {
        //Act: Set the fake response to throw an error
        viewModel.getPopularMovies(page = -500)
        testDispatcher.scheduler.advanceUntilIdle()

        val popularMoviesStates = viewModel.popularMovies.value


        // Assert: Verify the flow emits loading then error
        Assert.assertEquals(
            2131624064,
            (popularMoviesStates as DataState.Error).message
        )

    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}