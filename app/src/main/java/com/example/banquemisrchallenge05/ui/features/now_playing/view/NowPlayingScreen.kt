package com.example.banquemisrchallenge05.ui.features.now_playing.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel

@Composable
fun NowPlayingScreen(nowPlayingViewModel: NowPlayingViewModel, navController: NavHostController) {
    Text(text = "NowPlaying")
}