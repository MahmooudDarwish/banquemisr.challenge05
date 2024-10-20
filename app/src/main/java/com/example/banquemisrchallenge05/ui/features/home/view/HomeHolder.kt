package com.example.banquemisrchallenge05.ui.features.home.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.utils.navigation.Screen
import com.example.e_store.features.profile.view_model.HomeViewModel

@Composable
fun HomeHolder(navController: NavHostController, homeViewModel: HomeViewModel) {
    val items = listOf(
        Screen.NowPlaying,
        Screen.Popular,
        Screen.Upcoming,
    )

}


/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHomeScreen(
    homeViewModelFactory: HomeViewModelFactory,
    brandProductsViewModelFactory: BrandProductsViewModelFactory,
    shoppingCartViewModelFactory: ShoppingCartViewModelFactory,
    productInfoViewModelFactory: ProductInfoViewModelFactory,
    searchViewModelFactory: SearchViewModelFactory,
    categoriesViewModelFactory: CategoriesViewModelFactory,
    favouritesViewModelFactory: FavouritesViewModelFactory,
    profileViewModelFactory: ProfileViewModelFactory,
    ordersViewModelFactory: OrdersViewModelFactory,
    authenticationViewModelFactory: AuthenticationViewModelFactory,
    checkoutViewModelFactory: CheckoutViewModelFactory,
    addLocationFactory: AddLocationViewModelFactory,
    locationViewModelFactory: LocationViewModelFactory,
    mapViewModelFactory: MapViewModelFactory,
    paymentViewModelFactory: PaymentViewModelFactory,
    settingsViewModelFactory: SettingsViewModelFactory,
    favouriteControllerViewModelFactory: FavouriteControllerViewModelFactory,
) {


    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    val context = LocalContext.current
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

    // Managing the selected tab
    val selectedTabIndex = when {
        currentRoute.startsWith(Screen.Home.route) -> 0
        currentRoute.startsWith(Screen.Categories.route) -> 1
        currentRoute.startsWith(Screen.Cart.route) -> 2
        currentRoute.startsWith(Screen.Profile.route) -> 3
        else -> 0
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            Column {
                if (isInternetAvailable) {
                    // Tab bar at the top
                    TabRow(
                        selectedTabIndex = selectedTabIndex,
                        containerColor = Color.White,
                        contentColor = PrimaryColor
                    ) {
                        items.forEachIndexed { index, screen ->
                            Tab(
                                selected = selectedTabIndex == index,
                                onClick = {
                                    // Navigate to the selected tab's screen
                                    if (screen.route != currentRoute) {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                },
                                text = { Text(screen.title) }
                            )
                        }
                    }
                }
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White),
                    title = {
                        Text(
                            text = context.getString(R.string.app_name),
                            color = PrimaryColor,
                            fontStyle = FontStyle.Italic
                        )
                    }
                )
            }
        },
    ) { paddingValues ->
        if (isInternetAvailable) {
            Box(modifier = Modifier.padding(paddingValues)) {
                AppNavigation(
                    navController = navController,
                    homeViewModelFactory = homeViewModelFactory,
                    brandProductsViewModelFactory = brandProductsViewModelFactory,
                    categoriesViewModelFactory = categoriesViewModelFactory,
                    searchViewModelFactory = searchViewModelFactory,
                    profileViewModelFactory = profileViewModelFactory,
                    productInfoViewModelFactory = productInfoViewModelFactory,
                    favouritesViewModelFactory = favouritesViewModelFactory,
                    shoppingCartViewModelFactory = shoppingCartViewModelFactory,
                    ordersViewModelFactory = ordersViewModelFactory,
                    authenticationViewModelFactory = authenticationViewModelFactory,
                    checkoutViewModelFactory = checkoutViewModelFactory,
                    locationViewModelFactory = locationViewModelFactory,
                    mapViewModelFactory = mapViewModelFactory,
                    addLocationViewModelFactory = addLocationFactory,
                    paymentViewModelFactory = paymentViewModelFactory,
                    settingsViewModelFactory = settingsViewModelFactory,
                    favouriteControllerViewModelFactory = favouriteControllerViewModelFactory
                )
            }
        } else {
            NoInternetScreen()
        }
    }
}
*/