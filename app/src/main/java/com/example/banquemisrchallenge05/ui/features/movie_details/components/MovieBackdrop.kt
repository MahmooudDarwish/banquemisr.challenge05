package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.helpers.getImageUrl

@Composable
fun MovieBackdrop(movie: MovieDetails) {
    val isVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible.value = true
    }
        AnimatedVisibility(
            visible = isVisible.value,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000))
        ) {
            AsyncImage(
                model = getImageUrl(movie.backdrop_path ?: movie.poster_path ?: " "),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 20.dp)
            )
        }



}
