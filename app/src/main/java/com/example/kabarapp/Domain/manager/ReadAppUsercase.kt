package com.example.kabarapp.Domain.manager

import kotlinx.coroutines.flow.Flow

class ReadAppUsercase(private val localUserManager: LocalUserManager){
    suspend operator fun invoke() : Flow<Boolean> {
         return localUserManager.readAppEntry()
    }
}