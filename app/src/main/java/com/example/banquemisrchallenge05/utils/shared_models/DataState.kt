package com.example.banquemisrchallenge05.utils.shared_models

sealed class DataState<out T> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val message: Int) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}
