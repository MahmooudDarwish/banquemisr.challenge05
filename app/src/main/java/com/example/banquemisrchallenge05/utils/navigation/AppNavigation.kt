package com.example.banquemisrchallenge05.utils.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.banquemisrchallenge05.ui.features.home.view.HomeHolder
import com.example.banquemisrchallenge05.ui.features.movie_details.view.MovieDetailsScreen
import com.example.banquemisrchallenge05.ui.features.movie_details.view_model.MovieDetailsViewModel
import com.example.banquemisrchallenge05.ui.features.movie_details.view_model.MovieDetailsViewModelFactory
import com.example.banquemisrchallenge05.ui.features.now_playing.view.NowPlayingScreen
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModelFactory
import com.example.banquemisrchallenge05.ui.features.popular.view.PopularScreen
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModelFactory
import com.example.banquemisrchallenge05.ui.features.splash.view.SplashScreen
import com.example.banquemisrchallenge05.ui.features.splash.view_model.SplashViewModel
import com.example.banquemisrchallenge05.ui.features.splash.view_model.SplashViewModelFactory
import com.example.banquemisrchallenge05.ui.features.upcoming.view.UpcomingScreen
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModelFactory
import com.example.banquemisrchallenge05.utils.constants.NavigationKeys
import com.example.e_store.features.profile.view_model.HomeViewModel
import com.example.e_store.features.profile.view_model.HomeViewModelFactory


@Composable
fun AppNavigation(
    navController: NavHostController,
    homeViewModelFactory: HomeViewModelFactory,
    movieDetailsViewModelFactory: MovieDetailsViewModelFactory,
    nowPlayingViewModelFactory: NowPlayingViewModelFactory,
    popularMoviesViewModelFactory: PopularViewModelFactory,
    upcomingMoviesViewModelFactory: UpcomingViewModelFactory,
    splashViewModelFactory: SplashViewModelFactory,
) {
    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            val viewModel: SplashViewModel = viewModel(factory = splashViewModelFactory)
            SplashScreen(navController = navController, splashViewModel = viewModel)
        }

        composable(route = Screen.Home.route) {
            val homeViewModel: HomeViewModel = viewModel(factory = homeViewModelFactory)
            val nowPlayingViewModel: NowPlayingViewModel =
                viewModel(factory = nowPlayingViewModelFactory)
            val popularViewModel: PopularViewModel =
                viewModel(factory = popularMoviesViewModelFactory)
            val upcomingViewModel: UpcomingViewModel =
                viewModel(factory = upcomingMoviesViewModelFactory)

            HomeHolder(
                navController = navController,
                homeViewModel = homeViewModel,
                nowPlayingViewModel = nowPlayingViewModel,
                popularViewModel = popularViewModel,
                upcomingViewModel = upcomingViewModel,
            )
        }

        composable(route = Screen.NowPlaying.route) {
            val viewModel: NowPlayingViewModel = viewModel(factory = nowPlayingViewModelFactory)
            NowPlayingScreen(
                nowPlayingViewModel = viewModel,
                navController = navController,
            )
        }
        composable(route = Screen.Popular.route) {
            val viewModel: PopularViewModel = viewModel(factory = popularMoviesViewModelFactory)
            PopularScreen(popularViewModel = viewModel, navController = navController)
        }

        composable(route = Screen.Upcoming.route) {
            val viewModel: UpcomingViewModel = viewModel(factory = upcomingMoviesViewModelFactory)
            UpcomingScreen(upcomingViewModel = viewModel, navController = navController)
        }

        composable(
            route = "${NavigationKeys.MOVIE_DETAILS_ROUTE}/{${NavigationKeys.MOVIE_ID}}",
            arguments = listOf(navArgument(NavigationKeys.MOVIE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val viewModel: MovieDetailsViewModel =
                viewModel(factory = movieDetailsViewModelFactory)
            val movieId = backStackEntry.arguments?.getInt(NavigationKeys.MOVIE_ID)

            MovieDetailsScreen(
                movieId = movieId,
                navController = navController,
                movieDetailsViewModel = viewModel,
            )
        }

    }
}
