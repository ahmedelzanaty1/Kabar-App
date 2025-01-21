package com.example.kabarapp.Domain.manager

import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}