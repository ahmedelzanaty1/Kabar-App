package com.example.kabarapp.navgraph

sealed class Route(val route : String){
    object OnBoardingScreen : Route(route ="OnBoardingScreen")
    object HomeScreen : Route(route = "HomeScreen")
    object DetailsScreen : Route(route ="DetailsScreen")
    object AppStartNavigation : Route(route = "AppStartNavigation")
    object NewsNavigator : Route(route = "NewsNavigator")
    object BookMarkScreen : Route(route = "BookMarkScreen")
    object NewsNavigatorScreen : Route(route = "NewsNavigatorScreen")
    object SearchScreen : Route(route = "SearchScreen")
}