package com.example.kabarapp.Data.Api.repository

import androidx.paging.PagingData
import com.example.kabarapp.Data.Api.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getnews(sources: List<String>): Flow<PagingData<Article>>
}