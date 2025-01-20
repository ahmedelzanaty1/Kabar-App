package com.example.kabarapp.di

import android.app.Application
import com.example.kabarapp.Data.UserManager
import com.example.kabarapp.Domain.manager.AppEntryUserCase
import com.example.kabarapp.Domain.manager.LocalUserManager
import com.example.kabarapp.Domain.manager.ReadAppUsercase
import com.example.kabarapp.Domain.manager.SaveAppUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = UserManager(application)
    @Provides
    fun provideAppEntryUsecase(
        localUserManager: LocalUserManager
    ) = AppEntryUserCase(
        readAppUsercase = ReadAppUsercase(localUserManager),
        saveAppUsecase = SaveAppUsecase(localUserManager)
    )
}