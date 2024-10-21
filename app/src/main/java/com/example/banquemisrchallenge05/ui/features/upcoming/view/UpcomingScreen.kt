package com.example.banquemisrchallenge05.ui.features.upcoming.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import com.example.banquemisrchallenge05.utils.shared_components.MovieList


@Composable
fun UpcomingScreen(upcomingViewModel: UpcomingViewModel, navController: NavController) {
    val popularMoviesUiState by upcomingViewModel.upcomingMovies.collectAsStateWithLifecycle()

    MovieList(
        moviesUiState = popularMoviesUiState,
        onFetchMovies = { upcomingViewModel.getUpcomingMovies() },
        navController = navController,
        currentPage = upcomingViewModel.currentPage,
        onMovieChange = { page: Int ->
            upcomingViewModel.currentPage = page
        },
    )
}