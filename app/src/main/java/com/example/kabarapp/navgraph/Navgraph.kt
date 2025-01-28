import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.kabarapp.Home.HomeViewModel
import com.example.kabarapp.OnBoarding.OnBoardingScreen
import com.example.kabarapp.Search.SearchScreen
import com.example.kabarapp.Search.SearchState
import com.example.kabarapp.Search.SearchViewModel
import com.loc.newsapp.presentation.home.HomeScreen

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                OnBoardingScreen(event = {
                    navController.navigate(Route.NewsNavigation.route)
                })
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                NewsNavigator()

            }
        }

        }
    }


