package com.example.banquemisrchallenge05.ui.features.upcoming.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import com.example.banquemisrchallenge05.utils.shared_components.MovieList


@Composable
fun UpcomingScreen(upcomingViewModel: UpcomingViewModel, navController: NavController) {
    val popularMoviesUiState by upcomingViewModel.upcomingMovies.collectAsStateWithLifecycle()

    MovieList(
        moviesUiState = popularMoviesUiState,
        onFetchMovies = { upcomingViewModel.getUpcomingMovies() },
        navController = navController

    )
}