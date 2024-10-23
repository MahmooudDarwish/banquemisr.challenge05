package com.example.banquemisrchallenge05.ui.features.movie_details.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.ui.features.movie_details.components.MovieDetailsContent
import com.example.banquemisrchallenge05.ui.features.movie_details.view_model.MovieDetailsViewModel
import com.example.banquemisrchallenge05.utils.shared_components.BackButton
import com.example.banquemisrchallenge05.utils.shared_components.CustomLottieAnimation
import com.example.banquemisrchallenge05.utils.shared_components.LottieWithText
import com.example.banquemisrchallenge05.utils.shared_components.MoviesLoadingIndicator
import com.example.banquemisrchallenge05.utils.shared_models.DataState

@Composable
fun MovieDetailsScreen(
    movieId: Int?,
    navController: NavHostController,
    movieDetailsViewModel: MovieDetailsViewModel,
) {
    val movieDetailsUiState by movieDetailsViewModel.movieDetails.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        Log.d("TAG", "MovieDetailsScreen: $movieId")
        movieDetailsViewModel.getMovieDetails(movieId!!)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            BackButton(
                onBackClick = {
                    navController.navigateUp()
                }
            )
            CustomLottieAnimation(
                lottieRawRes = R.raw.logo,
                modifier = Modifier
                    .height(50.dp)
                    .align(Alignment.Center)
            )

        }


        when (movieDetailsUiState) {
            is DataState.Loading -> {
                MoviesLoadingIndicator()
            }

            is DataState.Success -> {
                val movie = (movieDetailsUiState as DataState.Success).data
                MovieDetailsContent(movie)
            }

            is DataState.Error -> {
                LottieWithText(
                    textId = (movieDetailsUiState as DataState.Error).message,
                    lottieAnimation = R.raw.error
                )
            }
        }
    }
}
