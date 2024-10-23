package com.example.banquemisrchallenge05.ui.features.movie_details.components
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.shared_components.Gap

@Composable
fun MovieInfo(movie: MovieDetails) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            val isVisible = remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                isVisible.value = true
            }

            AnimatedVisibility(
                visible = isVisible.value,
                enter = slideInHorizontally(
                    initialOffsetX = { -it },
                    animationSpec = tween(durationMillis = 500)
                )
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            AnimatedVisibility(
                visible = isVisible.value,
                enter = slideInHorizontally(
                    initialOffsetX = { -it },
                    animationSpec = tween(durationMillis = 500, delayMillis = 100)
                )
            ) {
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }


        val scaleState = remember { mutableFloatStateOf(0f) }
        val scale by animateFloatAsState(
            targetValue = scaleState.floatValue,
            animationSpec = tween(durationMillis = 500), label = ""
        )

        LaunchedEffect(Unit) {
            scaleState.floatValue = 1f
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.scale(scale)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rate_circle),
                    contentDescription = "back circle",
                    contentScale = ContentScale.Fit
                )
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = String.run { format("%.1f", movie.vote_average) },
                    fontSize = 26.sp,
                )
            }
            Gap(height = 5)
            Text(
                text = "(${movie.vote_count} votes)",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
