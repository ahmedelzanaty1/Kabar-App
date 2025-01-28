package com.example.kabarapp.Domain.manager

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val selectArticle: SelectArticle,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val getSavedArticle: GetSavedArticle

    )
