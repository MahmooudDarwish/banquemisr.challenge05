package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun CustomLottieAnimation(
    lottieRawRes: Int,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(lottieRawRes))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .padding(bottom = 16.dp)
        ) {
            LottieAnimation(
                speed = 2f,
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}


