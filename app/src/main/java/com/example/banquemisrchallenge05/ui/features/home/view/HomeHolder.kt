package com.example.banquemisrchallenge05.ui.features.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.ui.features.now_playing.view.NowPlayingScreen
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel
import com.example.banquemisrchallenge05.ui.features.popular.view.PopularScreen
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.ui.features.upcoming.view.UpcomingScreen
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import com.example.banquemisrchallenge05.utils.navigation.Screen
import com.example.e_store.features.profile.view_model.HomeViewModel

@Composable
fun HomeHolder(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    nowPlayingViewModel: NowPlayingViewModel,
    popularViewModel: PopularViewModel,
    upcomingViewModel: UpcomingViewModel,
) {
    val tabItems = listOf(
        Screen.NowPlaying,
        Screen.Popular,
        Screen.Upcoming
    )

    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        // Tab Row
        TabRow(
            modifier = Modifier.padding(top = 50.dp),
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Black,
            contentColor = Color.White,
        ) {
            tabItems.forEachIndexed { index, screen ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            stringResource(id = screen.title),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> {
                NowPlayingScreen(
                    nowPlayingViewModel = nowPlayingViewModel,
                    navController = navController,
                )
            }

            1 -> {
                PopularScreen(
                    popularViewModel = popularViewModel,
                    navController = navController,
                )
            }

            2 -> {
                UpcomingScreen(
                    upcomingViewModel = upcomingViewModel,
                    navController = navController,
                )
            }
        }
    }

}

