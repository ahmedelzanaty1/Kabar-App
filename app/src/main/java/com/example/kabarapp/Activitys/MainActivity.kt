package com.example.kabarapp.Activitys

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.kabarapp.Domain.manager.AppEntryUserCase
import com.example.kabarapp.OnBoarding.OnBoardingScreen
import com.example.kabarapp.OnBoarding.OnBoardingViewModel
import com.example.kabarapp.Utils.MainViewModel
import com.example.kabarapp.navgraph.NavGraph
import com.example.kabarapp.ui.theme.KabarAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition.value
            }
        }
        enableEdgeToEdge()
        setContent {
            KabarAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val startDestination = viewModel.startDestination.value
                        NavGraph(startDestination = startDestination)

                    }
                }
            }
        }
    }
}
