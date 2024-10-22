package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.banquemisrchallenge05.utils.helpers.getImageUrl

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .width(180.dp)
            .height(300.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = getImageUrl(movie.poster_path ?: movie.backdrop_path ?: " "),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            ),
                            startY = 100f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                Text(
                    text = movie.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray,
                    modifier = Modifier.testTag(movie.title)

                )
                Text(
                    text = movie.release_date,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray

                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(color = Color.Red, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = String.format("%.1f", movie.vote_average),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface

                )
            }
        }
    }
}
