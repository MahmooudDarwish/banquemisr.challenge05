package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.helpers.getImageUrl
import com.example.banquemisrchallenge05.utils.shared_components.BackButton

@Composable
fun MovieBackdrop(movie: MovieDetails, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        AsyncImage(
            model = getImageUrl(movie.backdrop_path ?: movie.poster_path ?: " "),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
        BackButton(
            onBackClick = {
                navController.navigateUp()
            }
        )
    }
}
