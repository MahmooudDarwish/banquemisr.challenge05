package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.banquemisrchallenge05.R

@Composable
fun MoviesLoadingIndicator() {
    Row(
        modifier = Modifier.fillMaxWidth().testTag("movies_loading"),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomLottieAnimation(lottieRawRes = R.raw.movie_loading, modifier = Modifier.fillMaxSize())
    }
}