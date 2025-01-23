package com.example.kabarapp.Domain.manager

import androidx.paging.PagingData
import com.example.kabarapp.Data.Api.Article
import com.example.kabarapp.Data.Api.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}