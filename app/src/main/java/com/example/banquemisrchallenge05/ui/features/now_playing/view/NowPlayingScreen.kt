package com.example.banquemisrchallenge05.ui.features.now_playing.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel
import com.example.banquemisrchallenge05.utils.shared_components.MovieList


@Composable
fun NowPlayingScreen(nowPlayingViewModel: NowPlayingViewModel, navController: NavController) {

    val nowPlayingMoviesUiState by nowPlayingViewModel.nowPlayingMovies.collectAsStateWithLifecycle()

    MovieList(
        moviesUiState = nowPlayingMoviesUiState,
        onFetchMovies = { nowPlayingViewModel.getNowPlayingMovies() },
        navController= navController
    )
}

