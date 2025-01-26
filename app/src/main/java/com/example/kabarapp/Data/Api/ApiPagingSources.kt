package com.example.kabarapp.Data.Api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kabarapp.Data.Local.Article

class ApiPagingSources (
    private val api: NewsApi,
    private val sources: String
): PagingSource<Int, Article>() {

    var totalNewsCount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchor ->
            val anchorPage = state.closestPageToPosition(anchor)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = api.GetNews(page = page, sources = sources)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )

        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )

        }

    }
}