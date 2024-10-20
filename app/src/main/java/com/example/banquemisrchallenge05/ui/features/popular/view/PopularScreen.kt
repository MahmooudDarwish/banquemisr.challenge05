package com.example.banquemisrchallenge05.ui.features.popular.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.utils.shared_components.MovieList

@Composable
fun PopularScreen(popularViewModel: PopularViewModel, navController: NavHostController) {

    val popularMoviesUiState by popularViewModel.popularMovies.collectAsStateWithLifecycle()

    MovieList(
        moviesUiState = popularMoviesUiState,
        onFetchMovies = { popularViewModel.getPopularMovies() },
    )
}