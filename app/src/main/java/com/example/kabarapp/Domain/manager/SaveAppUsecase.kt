package com.example.kabarapp.Domain.manager

class SaveAppUsecase(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}