package com.example.kabarapp.Details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabarapp.Data.Local.Article
import com.example.kabarapp.Domain.manager.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetalilsViewModel @Inject constructor (
    private val newsUseCase: NewsUseCase

) : ViewModel() {
    var sideEffect by mutableStateOf<String?>(null)
        private set

     fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCase.getSavedArticle(event.article.url)
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)

                    }
                }

            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }

        }
    }

    private fun deleteArticle(article: Article) {
        viewModelScope.launch {
            newsUseCase.deleteArticle(article)
            sideEffect = "Article Deleted"
        }


    }

    private fun upsertArticle(article: Article) {
        viewModelScope.launch {
            newsUseCase.upsertArticle(article)
            sideEffect = "Article Saved"
        }


    }

}