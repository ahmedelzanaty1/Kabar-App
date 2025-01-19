package com.example.kabarapp.OnBoarding

import androidx.annotation.DrawableRes
import com.example.kabarapp.R

data class Pages(
    val title: String,
    val description: String,
    @DrawableRes val icon: Int
    )
val pages = listOf(
    Pages(
        title = "Home",
        description = "You are in right place for news worldwide",
        icon = R.drawable.onboarding1
    ),
    Pages(
        title = "Search",
        description = "search for everything you want",
        icon = R.drawable.onboarding2
    ),
    Pages(
        title = "Saved",
        description = "save your favorite news and back for it when you need it",
        icon = R.drawable.onboarding3
    )
)

