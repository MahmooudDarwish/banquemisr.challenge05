package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import com.example.banquemisrchallenge05.utils.shared_models.Movie

@Composable
fun MovieList(
    moviesUiState: DataState<List<Movie>>,
    onFetchMovies: () -> Unit,
    navController: NavController,
) {
    LaunchedEffect(Unit) {
        onFetchMovies()
    }

    when (moviesUiState) {
        is DataState.Loading -> {
            MoviesLoadingIndicator()
        }

        is DataState.Success -> {
            val movies = moviesUiState.data
            MovieCarousel(movies = movies, navController = navController)
        }

        is DataState.Error -> {

        }
    }
}
