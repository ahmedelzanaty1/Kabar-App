package com.example.kabarapp.Data.Api

import com.example.kabarapp.Data.Local.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)