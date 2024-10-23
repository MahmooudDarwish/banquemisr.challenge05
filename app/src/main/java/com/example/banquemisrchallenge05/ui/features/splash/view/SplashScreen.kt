package com.example.banquemisrchallenge05.ui.features.splash.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.ui.features.splash.view_model.SplashViewModel
import com.example.banquemisrchallenge05.utils.navigation.Screen
import com.example.banquemisrchallenge05.utils.shared_components.CustomLottieAnimation
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, splashViewModel: SplashViewModel) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        CustomLottieAnimation(
            lottieRawRes = R.raw.logo,
            modifier = Modifier.size(200.dp)
        )
    }
}