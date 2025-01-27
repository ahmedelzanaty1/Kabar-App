package com.example.kabarapp.BookMark

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabarapp.Domain.manager.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.compose.runtime.State


@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
):ViewModel() {
    private val _state = mutableStateOf(BookMarkState())
    val state: State<BookMarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        newsUseCase.selectArticle().onEach {
            _state.value = _state.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }
}