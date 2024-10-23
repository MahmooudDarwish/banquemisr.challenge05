package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.utils.test_utils.TestTags

@Composable
fun MoviesLoadingIndicator() {
    val isDarkTheme = isSystemInDarkTheme()
    val lottieRes = if (isDarkTheme) {
        R.raw.movie_loading_dark
    } else {
        R.raw.movie_loading_light
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(TestTags.MOVIES_LOADING_TAG),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomLottieAnimation(lottieRawRes = lottieRes, modifier = Modifier.fillMaxSize())
    }
}
