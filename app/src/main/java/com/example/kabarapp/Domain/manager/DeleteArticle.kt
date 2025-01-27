package com.example.kabarapp.Domain.manager

import com.example.kabarapp.Data.Local.Article
import com.example.kabarapp.Data.Local.NewsDao

class DeleteArticle (
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) {
        newsDao.delete(article)
    }
}