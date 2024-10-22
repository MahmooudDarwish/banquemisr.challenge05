package com.example.banquemisrchallenge05.ui.features.now_playing.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import com.example.banquemisrchallenge05.utils.helpers.handleError
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import com.example.banquemisrchallenge05.utils.shared_models.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NowPlayingViewModel(private val repository: MoviesRepository, private val dispatcher : CoroutineDispatcher = Dispatchers.IO ) : ViewModel() {

    private val _nowPlayingMovies = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val nowPlayingMovies = _nowPlayingMovies.asStateFlow()

    var currentMovie by mutableIntStateOf(0)

    private val TAG = "NowPlayingViewModel"
    fun getNowPlayingMovies(page: Int = 1) {
        _nowPlayingMovies.value = DataState.Loading
        viewModelScope.launch(dispatcher) {
            try {
                repository.fetchNowPlayingMovies(page = page).collect { movies ->
                    _nowPlayingMovies.value = DataState.Success(movies)
                }
            } catch (ex: Throwable) {
                _nowPlayingMovies.value = handleError(ex)
            }
        }
    }
}
