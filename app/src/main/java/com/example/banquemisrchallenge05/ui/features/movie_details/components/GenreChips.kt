package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.banquemisrchallenge05.ui.features.movie_details.model.Genre

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenreChips(genres: List<Genre>) {
    val chipColors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan)
    FlowRow(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
    ) {
        genres.forEachIndexed { index, genre ->
            GenreChip(
                genreName = genre.name,
                color = chipColors[index % chipColors.size]
            )
        }
    }
}