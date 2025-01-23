package com.example.kabarapp.Data.Api.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kabarapp.Data.Api.ApiPagingSources
import com.example.kabarapp.Data.Api.Article
import com.example.kabarapp.Data.Api.NewsApi
import kotlinx.coroutines.flow.Flow

class NewsImplement(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getnews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                ApiPagingSources(
                    api = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    api = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow


    }

}

