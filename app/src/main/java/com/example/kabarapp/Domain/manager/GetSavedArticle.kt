package com.example.kabarapp.Domain.manager

import com.example.kabarapp.Data.Local.Article
import com.example.kabarapp.Data.Local.NewsDao
import javax.inject.Inject

class GetSavedArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}