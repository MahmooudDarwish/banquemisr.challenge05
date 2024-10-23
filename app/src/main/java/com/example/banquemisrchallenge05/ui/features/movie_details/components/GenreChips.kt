package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.banquemisrchallenge05.ui.features.movie_details.model.Genre

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenreChips(genres: List<Genre>) {
    val chipColors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan)

    val visibleChips = remember { mutableStateOf(List(genres.size) { false }) }

    LaunchedEffect(Unit) {
        genres.forEachIndexed { index, _ ->
            delay(100L * index)
            visibleChips.value = List(visibleChips.value.size) { i -> i <= index }
        }
    }

    FlowRow(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
    ) {
        genres.forEachIndexed { index, genre ->
            AnimatedVisibility(
                visible = visibleChips.value[index],
                enter = slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(durationMillis = 300)
                )
            ) {
                GenreChip(
                    genreName = genre.name,
                    color = chipColors[index % chipColors.size]
                )
            }
        }
    }
}
