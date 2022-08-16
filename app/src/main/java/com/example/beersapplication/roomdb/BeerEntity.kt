package com.example.beersapplication.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.beersapplication.model.Beers

@Entity(tableName = "beers")
class BeerEntity(val beerEntityModel: Beers) {
    @PrimaryKey(autoGenerate = true)
    var generatedId: Int = 0


}