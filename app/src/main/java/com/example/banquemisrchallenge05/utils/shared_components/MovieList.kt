package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import com.example.weather.utils.managers.InternetChecker

@Composable
fun MovieList(
    moviesUiState: DataState<List<Movie>>,
    onFetchMovies: () -> Unit,
    navController: NavController,
    currentPage: Int,
    onMovieChange: (Int) -> Unit,
) {
    val context = LocalContext.current
    val internetChecker = remember { InternetChecker(context) }
    var isInternetAvailable by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {

        internetChecker.startMonitoring()
        internetChecker.networkStateFlow.collect { isConnected ->
            isInternetAvailable = isConnected
            onFetchMovies()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            internetChecker.stopMonitoring()
        }
    }
    when (moviesUiState) {
        is DataState.Loading -> {
            MoviesLoadingIndicator()
        }

        is DataState.Success -> {
            val movies = moviesUiState.data
            MovieCarousel(
                movies = movies,
                navController = navController,
                currentPage = currentPage,
                onMovieChange = onMovieChange
            )
        }

        is DataState.Error -> {

            LottieWithText(
                textId = moviesUiState.message,
                lottieAnimation = R.raw.error
            )

        }
    }
}
