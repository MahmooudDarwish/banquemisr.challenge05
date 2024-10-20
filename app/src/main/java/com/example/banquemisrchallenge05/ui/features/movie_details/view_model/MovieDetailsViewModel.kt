package com.example.banquemisrchallenge05.ui.features.movie_details.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import com.example.banquemisrchallenge05.ui.features.movie_details.model.MovieDetails
import com.example.banquemisrchallenge05.utils.helpers.handleError
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repository: MoviesRepository) : ViewModel() {


    private val _movieDetails = MutableStateFlow<DataState<MovieDetails>>(DataState.Loading)
    val movieDetails = _movieDetails.asStateFlow()

    fun getMovieDetails(movieId: Int) {
        _movieDetails.value = DataState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.fetchMovieDetails(movieId = movieId).collect { movie ->
                    _movieDetails.value = DataState.Success(movie)
                }
            } catch (ex: Throwable) {
                _movieDetails.value = handleError(ex)
            }
        }
    }




}