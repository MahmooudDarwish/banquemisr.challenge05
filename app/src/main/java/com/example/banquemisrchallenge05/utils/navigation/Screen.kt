package com.example.banquemisrchallenge05.utils.navigation

import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.utils.constants.NavigationKeys

sealed class Screen(val route: String, val title: Int) {

    data object Splash : Screen(route = NavigationKeys.SPLASH_ROUTE, title = R.string.splash_title)
    data object Home : Screen(route = NavigationKeys.HOME_ROUTE, title = R.string.home_title)
    data object MovieDetails :
        Screen(route = NavigationKeys.MOVIE_DETAILS_ROUTE, title = R.string.movie_details) {
        fun createRoute(movieId: Int) = "$route/$movieId"
    }

    data object NowPlaying :
        Screen(route = NavigationKeys.NOW_PLAYING_ROUTE, title = R.string.now_playing_title)

    data object Popular :
        Screen(route = NavigationKeys.POPULAR_ROUTE, title = R.string.popular_title)

    data object Upcoming :
        Screen(route = NavigationKeys.UPCOMING_ROUTE, title = R.string.upcoming_title)

}