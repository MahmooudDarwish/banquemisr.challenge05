package com.example.banquemisrchallenge05.ui.features.upcoming.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.banquemisrchallenge05.data_layer.MoviesRepository
import com.example.banquemisrchallenge05.data_layer.MoviesRepositoryImpl
import com.example.banquemisrchallenge05.data_layer.remote.TMDbRemoteDataSourceImpl
import com.example.banquemisrchallenge05.ui.features.home.view.HomeHolder
import com.example.banquemisrchallenge05.ui.features.home.view_model.HomeViewModel
import com.example.banquemisrchallenge05.ui.features.movie_details.view.MovieDetailsScreen
import com.example.banquemisrchallenge05.ui.features.movie_details.view_model.MovieDetailsViewModel
import com.example.banquemisrchallenge05.ui.features.now_playing.view_model.NowPlayingViewModel
import com.example.banquemisrchallenge05.ui.features.popular.view_model.PopularViewModel
import com.example.banquemisrchallenge05.ui.features.upcoming.view_model.UpcomingViewModel
import com.example.banquemisrchallenge05.utils.constants.NavigationKeys
import com.example.banquemisrchallenge05.utils.navigation.Screen
import com.example.banquemisrchallenge05.utils.test_utils.TestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UpcomingScreenKtTest{
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var repository: MoviesRepository
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var nowPlayingViewModel: NowPlayingViewModel
    private lateinit var popularViewModel: PopularViewModel
    private lateinit var upcomingViewModel: UpcomingViewModel
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel



    @Before
    fun setup() {
        repository =
            MoviesRepositoryImpl.getInstance(
                TMDbRemoteDataSourceImpl.getInstance(),
            )
        homeViewModel = HomeViewModel(repository)
        nowPlayingViewModel = NowPlayingViewModel(repository)
        popularViewModel = PopularViewModel(repository)
        upcomingViewModel = UpcomingViewModel(repository)
        movieDetailsViewModel = MovieDetailsViewModel(repository)

    }

    @Test
    fun testNavigationToMovieDetails() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) {
                    HomeHolder(
                        navController = navController,
                        homeViewModel = homeViewModel,
                        nowPlayingViewModel = nowPlayingViewModel,
                        popularViewModel = popularViewModel,
                        upcomingViewModel = upcomingViewModel,
                    )
                }
                composable(
                    route = "${NavigationKeys.MOVIE_DETAILS_ROUTE}/{${NavigationKeys.MOVIE_ID}}",
                    arguments = listOf(navArgument(NavigationKeys.MOVIE_ID) { type = NavType.IntType })
                ) { backStackEntry ->
                    val movieId = backStackEntry.arguments?.getInt(NavigationKeys.MOVIE_ID)
                    MovieDetailsScreen(
                        movieId = movieId,
                        navController = navController,
                        movieDetailsViewModel = movieDetailsViewModel,
                    )
                }
            }
        }

        // Check that the home screen is displayed
        composeTestRule.onNodeWithTag(TestTags.MOVIES_LOADING_TAG).assertExists()
        Thread.sleep(1000)

        // Click on the "Upcoming" tab and assert that it is selected
        composeTestRule.onNodeWithTag(TestTags.UP_COMING_TAG).performClick()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag(TestTags.UP_COMING_SELECTED_TAG).assertExists()
        Thread.sleep(1000)

        // Swipe left in the carousel and select a movie
        composeTestRule.onNodeWithTag(TestTags.MOVIE_CAROUSEL_TAG )
            .performTouchInput { swipeLeft() }
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag(TestTags.MOVIE_CAROUSEL_TAG )
            .performTouchInput { swipeLeft() }
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag(TestTags.MOVIE_CAROUSEL_TAG )
            .performTouchInput { swipeLeft() }
        Thread.sleep(1000)


        // Click on a movie card and assert that the movie details screen is shown
        composeTestRule.onNodeWithTag(TestTags.MOVIE_CARD_6_TAG).performClick()
        composeTestRule.waitForIdle()


    }
    @Test
    fun testStatePersistenceAfterBackNavigation() {
        // Perform navigation and interact with movie carousel
        testNavigationToMovieDetails()

        // Click the back button to go back to the home screen
        composeTestRule.onNodeWithTag(TestTags.BACK_BUTTON_TAG).performClick()
        Thread.sleep(1000)

        // Verify that the "Upcoming" tab is still selected and the previous state is persisted
        composeTestRule.onNodeWithTag(TestTags.UP_COMING_SELECTED_TAG).assertExists()
        composeTestRule.onNodeWithTag(TestTags.MOVIE_CARD_6_TAG).assertExists() // Ensure the same movie is still there
        composeTestRule.waitForIdle()

    }
}