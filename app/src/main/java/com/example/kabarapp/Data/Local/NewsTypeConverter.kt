package com.example.kabarapp.Data.Local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.kabarapp.Data.Api.Source

@ProvidedTypeConverter
class NewsTypeConverter {
    @TypeConverter
    fun fromSource(source: Source): String {
        return "${source.id},${source.name}"
    }
    @TypeConverter
    fun toSource(name: String): Source {
        val list = name.split(",")
        return Source(id = list[0], name = list[1])
    }

}