package com.example.kabarapp.Details

import com.example.kabarapp.Data.Local.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()

}