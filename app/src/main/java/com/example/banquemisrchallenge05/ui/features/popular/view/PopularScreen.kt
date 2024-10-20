package com.example.banquemisrchallenge05.ui.features.popular.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel

@Composable
fun PopularScreen(popularViewModel: PopularViewModel, navController: NavHostController) {
    Text(text = "Popular")
}