package com.example.kabarapp.Data.Local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
@ProvidedTypeConverter
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSource(sourceJson: String): Source {
        val type = object : TypeToken<Source>() {}.type
        return Gson().fromJson(sourceJson, type)
    }
}
