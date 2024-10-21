package com.example.banquemisrchallenge05.utils.shared_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LottieWithText(textId: Int, lottieAnimation: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CustomLottieAnimation(
            lottieRawRes = lottieAnimation,
            modifier = Modifier.size(200.dp)
        )
        Gap(height = 20)
        Text(
            text = stringResource(id = textId),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
