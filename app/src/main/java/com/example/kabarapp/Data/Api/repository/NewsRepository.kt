package com.example.kabarapp.Data.Api.repository

import androidx.paging.PagingData
import com.example.kabarapp.Data.Local.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getnews(sources: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

}