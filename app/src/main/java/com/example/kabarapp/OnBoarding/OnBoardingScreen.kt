package com.example.kabarapp.OnBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0){
            pages.size
        }
        val ButtonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pagerState) { page ->
            PagesView(pages = pages[page])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
            ,horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ,verticalAlignment = Alignment.CenterVertically

        ) {
            Indicator(
                modifier = Modifier.width(52.dp),
                pagesize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if (ButtonState.value.first().isNotEmpty()) {
                    ButtonTextView(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }

                    }, text = ButtonState.value.first())
                }
                ButtonView(text = ButtonState.value[1], onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            //TODO navigate to home screen
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }

                })


            }
        }
    }
    
}