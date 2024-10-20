package com.example.banquemisrchallenge05.ui.features.landing.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import java.lang.IllegalArgumentException

class LandingViewModelFactory(private val _irepo: MoviesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LandingViewModel::class.java)) {
            LandingViewModel(_irepo) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}