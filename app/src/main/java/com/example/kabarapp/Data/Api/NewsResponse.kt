package com.example.kabarapp.Data.Api

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)