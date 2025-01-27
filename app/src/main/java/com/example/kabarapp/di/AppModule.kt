package com.example.kabarapp.di
import android.app.Application
import androidx.room.Room
import com.example.kabarapp.Data.Api.NewsApi
import com.example.kabarapp.Data.Api.repository.NewsImplement
import com.example.kabarapp.Data.Api.repository.NewsRepository
import com.example.kabarapp.Data.Local.NewsDao
import com.example.kabarapp.Data.Local.NewsDataBase
import com.example.kabarapp.Data.Local.NewsTypeConverter
import com.example.kabarapp.Data.UserManager
import com.example.kabarapp.Domain.manager.AppEntryUserCase
import com.example.kabarapp.Domain.manager.GetNews
import com.example.kabarapp.Domain.manager.LocalUserManager
import com.example.kabarapp.Domain.manager.NewsUseCase
import com.example.kabarapp.Domain.manager.ReadAppEntry
import com.example.kabarapp.Domain.manager.SaveAppUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = UserManager(application)
    @Provides
    @Singleton
    fun provideAppEntryUsecase(
        localUserManager: LocalUserManager
    ) = AppEntryUserCase(
        readAppUsercases = ReadAppEntry(localUserManager),
        saveAppUsecases = SaveAppUsecase(localUserManager)
    )
    @Provides
    @Singleton
    fun providenewsapi() : NewsApi {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsImplement(newsApi)




    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
        , newsDao: NewsDao
    ) : NewsUseCase {
        return NewsUseCase(
            getNews = GetNews(newsRepository)
            , searchNews = com.example.kabarapp.Domain.manager.SearchNews(newsRepository)
        , selectArticle = com.example.kabarapp.Domain.manager.SelectArticle(newsDao)
        , upsertArticle = com.example.kabarapp.Domain.manager.UpsertArticle(newsDao)
        , deleteArticle = com.example.kabarapp.Domain.manager.DeleteArticle(newsDao))

    }
    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDataBase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDataBase
    ): NewsDao {
        return newsDatabase.newsdao
    }
}