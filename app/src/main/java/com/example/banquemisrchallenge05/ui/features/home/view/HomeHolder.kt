package com.example.banquemisrchallenge05.ui.features.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.banquemisrchallenge05.ui.features.now_playing.view.NowPlayingScreen
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel
import com.example.banquemisrchallenge05.ui.features.popular.view.PopularScreen
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.ui.features.upcoming.view.UpcomingScreen
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import com.example.banquemisrchallenge05.utils.navigation.Screen
import com.example.banquemisrchallenge05.ui.features.home.view_model.HomeViewModel
import com.example.banquemisrchallenge05.utils.shared_components.NoInternetScreen
import com.example.weather.utils.managers.InternetChecker

@Composable
fun HomeHolder(
    navController: NavController,
    homeViewModel: HomeViewModel,
    nowPlayingViewModel: NowPlayingViewModel,
    popularViewModel: PopularViewModel,
    upcomingViewModel: UpcomingViewModel,
) {
    val context = LocalContext.current
    val tabItems = listOf(
        Screen.NowPlaying,
        Screen.Popular,
        Screen.Upcoming
    )

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val internetChecker = remember { InternetChecker(context) }
    var isInternetAvailable by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        internetChecker.startMonitoring()
        internetChecker.networkStateFlow.collect { isConnected ->
            isInternetAvailable = isConnected
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            internetChecker.stopMonitoring()
        }
    }

    if (!isInternetAvailable) {
        NoInternetScreen()
    } else {
        Column(
            modifier = Modifier.padding(top = 50.dp),
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
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
}
