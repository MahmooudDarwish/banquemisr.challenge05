package com.example.banquemisrchallenge05.utils.helpers

import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.utils.shared_models.DataState
import retrofit2.HttpException
import java.io.IOException

fun handleError(e: Throwable): DataState.Error {
    return when (e) {
        is IOException -> DataState.Error(R.string.network_error)
        is HttpException -> {
            when (e.code()) {
                404 -> DataState.Error(R.string.resource_not_found)
                500 -> DataState.Error(R.string.server_error)
                else -> DataState.Error(R.string.unknown_error)
            }
        }

        else -> DataState.Error(R.string.unexpected_error)
    }
}
