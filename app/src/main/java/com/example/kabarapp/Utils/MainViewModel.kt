package com.example.kabarapp.Utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabarapp.Domain.manager.AppEntryUserCase
import com.example.kabarapp.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUserCase: AppEntryUserCase
) : ViewModel() {

    private val _splashCondition = MutableStateFlow(true)
    val splashCondition: StateFlow<Boolean> = _splashCondition

    private val _startDestination = MutableStateFlow(Route.AppStartNavigation.route)
    val startDestination: StateFlow<String> = _startDestination

    init {
        viewModelScope.launch {
            appEntryUserCase.readAppUsercases()
                .onEach { shouldStartFromHomeScreen ->
                    _startDestination.value = if (shouldStartFromHomeScreen) {
                        Route.NewsNavigator.route
                    } else {
                        Route.AppStartNavigation.route
                    }
                    delay(200)
                    _splashCondition.value = false
                }
                .launchIn(this)
        }
    }
}
