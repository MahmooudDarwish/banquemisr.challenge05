package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.banquemisrchallenge05.R

@Composable
fun NoDataFound() {
    Column {
        CustomLottieAnimation(lottieRawRes = R.raw.no_data_found)
        Gap(height = 20)
        stringResource(id = R.string.no_data_found)
    }

}