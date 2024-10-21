package com.example.banquemisrchallenge05.ui.features.landing.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.banquemisrchallenge05.data_layer.MoviesRepositoryImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.ui.features.movie_details.view_model.MovieDetailsViewModelFactory
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModelFactory
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModelFactory
import com.example.banquemisrchallenge05.ui.features.splash.view_model.SplashViewModelFactory
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModelFactory
import com.example.banquemisrchallenge05.ui.theme.Banquemisrchallenge05Theme
import com.example.banquemisrchallenge05.utils.navigation.AppNavigation
import com.example.banquemisrchallenge05.ui.features.home.view_model.HomeViewModelFactory

class LandingActivity : ComponentActivity() {

    private val repo by lazy {
        MoviesRepositoryImpl.getInstance(
            TMDbRemoteDataSourceImpl.getInstance(),
        )
    }
    private val homeViewModelFactory by lazy { HomeViewModelFactory(repo) }
    private val movieDetailsViewModelFactory by lazy { MovieDetailsViewModelFactory(repo) }
    private val nowPlayingViewModelFactory by lazy { NowPlayingViewModelFactory(repo) }
    private val popularMoviesViewModelFactory by lazy { PopularViewModelFactory(repo) }
    private val upcomingMoviesViewModelFactory by lazy { UpcomingViewModelFactory(repo) }
    private val splashViewModelFactory by lazy { SplashViewModelFactory(repo) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Banquemisrchallenge05Theme {
                Surface {
                    val navController = rememberNavController()
                    AppNavigation(
                        navController = navController,
                        homeViewModelFactory = homeViewModelFactory,
                        movieDetailsViewModelFactory = movieDetailsViewModelFactory,
                        nowPlayingViewModelFactory = nowPlayingViewModelFactory,
                        popularMoviesViewModelFactory = popularMoviesViewModelFactory,
                        upcomingMoviesViewModelFactory = upcomingMoviesViewModelFactory,
                        splashViewModelFactory = splashViewModelFactory,
                    )
                }
            }
        }
    }
}