package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.banquemisrchallenge05.utils.helpers.getImageUrl
import com.example.banquemisrchallenge05.utils.shared_models.Movie

@Composable
fun MovieBackground(movie: Movie) {
    AsyncImage(
        model = getImageUrl(movie.poster_path),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
