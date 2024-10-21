package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.helpers.getAllCountryFlags
import com.example.banquemisrchallenge05.utils.shared_components.Gap

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ReleaseAndRuntimeInfo(movie: MovieDetails) {
    FlowRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        IconWithText(
            iconResId = R.drawable.ic_calendar,
            text = "${movie.release_date}  (${getAllCountryFlags(movie.production_countries)})"
        )
        Gap(width = 20)
        IconWithText(
            iconResId = R.drawable.ic_clock,
            text = "${movie.runtime} min"
        )
    }
}