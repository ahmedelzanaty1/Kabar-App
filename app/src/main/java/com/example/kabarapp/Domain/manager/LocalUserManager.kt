package com.example.kabarapp.Domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager  {
    suspend fun saveAppEntry()

    suspend fun readAppEntry() : Flow<Boolean>


}