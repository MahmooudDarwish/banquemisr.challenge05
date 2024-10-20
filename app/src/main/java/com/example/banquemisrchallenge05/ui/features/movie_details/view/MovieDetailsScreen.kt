package com.example.banquemisrchallenge05.ui.features.movie_details.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.banquemisrchallenge05.ui.features.movie_details.view_model.MovieDetailsViewModel
import com.example.banquemisrchallenge05.utils.helpers.getMovieImageUrl
import com.example.banquemisrchallenge05.utils.shared_components.BackButton
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

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        Log.d("TAG", "MovieDetailsScreen: $movieId")
        movieDetailsViewModel.getMovieDetails(movieId!!)
    }

    when (movieDetailsUiState) {
        is DataState.Loading -> {
            MoviesLoadingIndicator()
        }

        is DataState.Success -> {
            val movie = (movieDetailsUiState as DataState.Success).data
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    AsyncImage(
                        model = getMovieImageUrl(movie.backdrop_path),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                    BackButton(onBackClick = { navController.popBackStack() })
                }

                // Movie Title
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Overview
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Additional Information
                Text(
                    text = "Release Date: ${movie.release_date}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Runtime: ${movie.runtime} min",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Rating: ${movie.vote_average} (${movie.vote_count} votes)",
                    style = MaterialTheme.typography.bodyMedium
                )

                // Genres
                Text(
                    text = "Genres:",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                movie.genres.forEach { genre ->
                    Text(text = genre.name, style = MaterialTheme.typography.bodyMedium)
                }

                // Production Companies
                Text(
                    text = "Production Companies:",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                movie.production_companies.forEach { company ->
                    Text(text = company.name, style = MaterialTheme.typography.bodyMedium)
                }
            }

        }

        is DataState.Error -> {

            Toast.makeText(
                context,
                stringResource((movieDetailsUiState as DataState.Error).message),
                Toast.LENGTH_LONG
            ).show()
        }

    }

}
