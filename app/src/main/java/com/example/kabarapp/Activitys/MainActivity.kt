package com.example.kabarapp.Activitys

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.kabarapp.Domain.manager.AppEntryUserCase
import com.example.kabarapp.OnBoarding.OnBoardingScreen
import com.example.kabarapp.ui.theme.KabarAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var AppEntryUserCase: AppEntryUserCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        lifecycleScope.launch {
            AppEntryUserCase.readAppUsercase().collect{
                Log.e("test", it.toString() )
            }
        }
        enableEdgeToEdge()
        setContent {
            KabarAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        OnBoardingScreen()
                    }
                }
            }
        }
    }
}
