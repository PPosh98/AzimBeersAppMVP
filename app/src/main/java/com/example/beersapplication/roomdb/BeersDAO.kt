package com.example.beersapplication.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BeersDAO {

    @Query("SELECT * FROM beers ORDER BY generatedId ASC")
    fun readBeersFromDb() : Flow<List<BeerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createBeersInsideDb(beerEntity: BeerEntity)
}