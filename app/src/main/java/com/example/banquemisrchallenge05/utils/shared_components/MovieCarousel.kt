package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlin.math.absoluteValue

@Composable
fun MovieCarousel(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { movies.size })

    Box(modifier = modifier.fillMaxSize()) {
        // Background movie image
        movies.getOrNull(pagerState.currentPage)?.let { movie ->
            MovieBackground(movie = movie)
        }

        // Movie cards carousel
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (movies.isNotEmpty()) {
                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(horizontal = 50.dp),
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                    MovieCard(
                        movie = movies[page],
                        modifier = Modifier
                            .graphicsLayer {
                                val scale = lerp(
                                    start = 0.85f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                                scaleX = scale
                                scaleY = scale
                                alpha = lerp(
                                    start = 0.6f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            }
                            .padding(horizontal = 10.dp)
                            .aspectRatio(0.7f),
                        onClick = {
                            navController.navigate("movie_details/${movies[page].id}")
                        }
                    )
                }
            } else {
                LottieWithText(
                    textId =  R.string.no_data_found,
                    lottieAnimation = R.raw.no_data_found
                )
            }
        }
    }
}
