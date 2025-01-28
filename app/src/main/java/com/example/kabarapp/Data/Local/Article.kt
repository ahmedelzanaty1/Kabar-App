package com.example.kabarapp.Data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kabarapp.Data.Api.Source
import java.io.Serializable

@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
) : Serializable
data class Source(
    val id: String?,
    val name: String
) : Serializable