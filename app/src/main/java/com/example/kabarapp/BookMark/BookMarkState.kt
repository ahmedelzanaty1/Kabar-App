package com.example.kabarapp.BookMark

import com.example.kabarapp.Data.Local.Article

data class BookMarkState (
    val articles: List<Article> = emptyList()
)

