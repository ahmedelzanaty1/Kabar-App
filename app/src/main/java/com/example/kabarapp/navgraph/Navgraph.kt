package com.example.kabarapp.navgraph
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.kabarapp.OnBoarding.OnBoardingScreen
@Composable
fun NavGraph(modifier: Modifier = Modifier , startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                OnBoardingScreen(event = {
                    navController.navigate(Route.NewsNavigator.route)
                })
            }
        }
        navigation(
            route = Route.NewsNavigator.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                Text(text = "NewsNavigatorScreen")
            }
        }
    }
}
