package com.example.kabarapp.Domain.manager

import com.example.kabarapp.Data.Api.repository.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository

) {
    operator fun invoke(sources: List<String>) =
        newsRepository.getnews(sources = sources)

}