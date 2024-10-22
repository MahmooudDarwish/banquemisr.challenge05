package com.example.banquemisrchallenge05.ui.features.now_playing.view_model

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
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NowPlayingViewModelTest {
    private lateinit var repository: MoviesRepository
    private lateinit var viewModel: NowPlayingViewModel
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
        viewModel = NowPlayingViewModel(repository = repository, dispatcher = testDispatcher)
    }

    @Test
    fun fetchNowPlayingMovies_returnsCorrectMovies() = runTest {
        // Act: Trigger the ViewModel's function
        viewModel.getNowPlayingMovies()

        testDispatcher.scheduler.advanceUntilIdle()

        val nowPlayingMoviesStates = viewModel.nowPlayingMovies.value

        // Assert: Check if the state flow has emitted the correct success state
        assertTrue(nowPlayingMoviesStates is DataState.Success)
        assertEquals(
            MovieMockData.nowPlayingMovies,
            (nowPlayingMoviesStates as DataState.Success).data
        )
    }


    @Test
    fun fetchNowPlayingMovies_handleErrorCorrectly() = runTest {
        //Act: Set the fake response to throw an error
        viewModel.getNowPlayingMovies(page = -500)
        testDispatcher.scheduler.advanceUntilIdle()

        val nowPlayingMoviesStates = viewModel.nowPlayingMovies.value


        // Assert: Verify the flow emits loading then error
        assertEquals(
            2131624064,
            (nowPlayingMoviesStates as DataState.Error).message
        )

    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}