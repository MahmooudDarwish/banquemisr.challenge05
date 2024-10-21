package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun CustomLottieAnimation(
    lottieRawRes: Int,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(lottieRawRes))

    LottieAnimation(
        speed = 2f,
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}
