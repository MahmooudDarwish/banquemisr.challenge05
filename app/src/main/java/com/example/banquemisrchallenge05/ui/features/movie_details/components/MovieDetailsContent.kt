package com.example.banquemisrchallenge05.ui.features.movie_details.components

import androidx.compose.runtime.Composable
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails

@Composable
fun MovieDetailsContent(
    movie: MovieDetails,
) {
    MovieBackdrop(movie = movie)
    MovieInfo(movie = movie)
    GenreChips(genres = movie.genres)
    ReleaseAndRuntimeInfo(movie = movie)
    ProductionCompanies(productionCompanies = movie.production_companies)
}