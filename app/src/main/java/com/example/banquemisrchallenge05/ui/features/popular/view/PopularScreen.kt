package com.example.banquemisrchallenge05.ui.features.popular.view


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.utils.shared_components.MovieList

@Composable
fun PopularScreen(popularViewModel: PopularViewModel, navController: NavController) {

    val popularMoviesUiState by popularViewModel.popularMovies.collectAsStateWithLifecycle()

    MovieList(
        moviesUiState = popularMoviesUiState,
        onFetchMovies = { popularViewModel.getPopularMovies() },
        navController= navController,
        currentPage = popularViewModel.currentMovie,
        onMovieChange = { page: Int ->
            popularViewModel.currentMovie = page
        }

    )
}