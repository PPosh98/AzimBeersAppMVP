package com.example.beersapplication.roomdb

import androidx.room.TypeConverter
import com.example.beersapplication.model.Beers
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BeerTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun beerToString(beers: Beers): String = gson.toJson(beers)

    @TypeConverter
    fun stringToBeers(data: String): Beers {
        val listType = object : TypeToken<Beers>() {}.type
        return gson.fromJson(data, listType)
    }
}