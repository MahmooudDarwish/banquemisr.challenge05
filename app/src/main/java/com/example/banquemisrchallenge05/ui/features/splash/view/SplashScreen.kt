package com.example.banquemisrchallenge05.ui.features.splash.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    CustomLottieAnimation(
        lottieRawRes = R.raw.splash
    )
}