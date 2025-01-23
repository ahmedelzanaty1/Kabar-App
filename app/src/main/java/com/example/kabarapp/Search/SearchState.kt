package com.example.kabarapp.Search

import androidx.paging.PagingData
import com.example.kabarapp.Data.Api.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)