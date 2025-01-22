package com.example.kabarapp.Data.Api

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun GetNews(
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = "e5c3f8e5652540468ec1ad5245c8d988",
        @Query("sources") sources: String) : NewsResponse
}