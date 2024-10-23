package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.banquemisrchallenge05.ui.features.movie_details.model.ProductionCompany
import com.example.banquemisrchallenge05.utils.helpers.getImageUrl
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun ProductionCompanies(productionCompanies: List<ProductionCompany>) {
    val visibleCompanies = remember { mutableStateOf(List(productionCompanies.size) { false }) }

    LaunchedEffect(Unit) {
        productionCompanies.forEachIndexed { index, _ ->
            delay(100L * index)
            visibleCompanies.value = List(visibleCompanies.value.size) { i -> i <= index }
        }
    }

    productionCompanies.forEachIndexed { index, company ->
        AnimatedVisibility(
            visible = visibleCompanies.value[index],
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 300)
            )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = company.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    if (company.logo_path != null) {
                        AsyncImage(
                            model = getImageUrl(company.logo_path),
                            contentDescription = "${company.name} logo",
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }
}
