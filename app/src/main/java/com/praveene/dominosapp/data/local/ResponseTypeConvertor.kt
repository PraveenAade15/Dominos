package com.praveene.dominosapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.praveene.dominosapp.data.model.ResponseItem

class ResponseTypeConvertor {
    val gson = Gson()

    @TypeConverter
    fun articleToString(responseModelList: MutableList<ResponseItem>): String {
        return gson.toJson(responseModelList)
    }

    @TypeConverter
    fun stringToArticle(data: String): MutableList<ResponseItem> {
        val listType = object : TypeToken<MutableList<ResponseItem>>() {}.type
        return gson.fromJson(data, listType)
    }
}