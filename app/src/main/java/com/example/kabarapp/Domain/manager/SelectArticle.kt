package com.example.kabarapp.Domain.manager

import com.example.kabarapp.Data.Local.Article
import com.example.kabarapp.Data.Local.NewsDao
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }


}