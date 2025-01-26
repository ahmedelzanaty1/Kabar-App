package com.example.kabarapp.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Article::class], version = 1)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDataBase : RoomDatabase() {
    abstract val newsdao: NewsDao

}