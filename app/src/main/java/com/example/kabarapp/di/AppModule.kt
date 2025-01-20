package com.example.kabarapp.di

import android.app.Application
import com.example.kabarapp.Data.UserManager
import com.example.kabarapp.Domain.manager.AppEntryUsecase
import com.example.kabarapp.Domain.manager.LocalUserManager
import com.example.kabarapp.Domain.manager.ReadAppUsercase
import com.example.kabarapp.Domain.manager.SaveAppUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserManager(
        application: Application
    ): LocalUserManager = UserManager(application)
    @Provides
    @Singleton
    fun provideAppEntryUsecase(
        localUserManager: LocalUserManager
    ) = AppEntryUsecase(
        saveAppUsecase = SaveAppUsecase(localUserManager),
        readAppUsercase = ReadAppUsercase(localUserManager))

}