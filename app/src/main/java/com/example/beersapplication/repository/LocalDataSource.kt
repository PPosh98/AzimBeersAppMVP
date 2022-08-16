package com.example.beersapplication.repository

import com.example.beersapplication.api.FetchAPI
import com.example.beersapplication.roomdb.BeerEntity
import com.example.beersapplication.roomdb.BeersDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(val beersDAO: BeersDAO, fetchAPI: FetchAPI) {

    fun insertBeersIntoDb(beerEntity: BeerEntity) = beersDAO.createBeersInsideDb(beerEntity)

    fun readBeersFromDb() = beersDAO.readBeersFromDb()

}