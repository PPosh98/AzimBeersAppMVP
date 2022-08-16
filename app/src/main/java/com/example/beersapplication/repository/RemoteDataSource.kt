package com.example.beersapplication.repository

import com.example.beersapplication.api.FetchAPI
import com.example.beersapplication.model.Beers
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val fetchAPI: FetchAPI){

    suspend fun getBeers() = fetchAPI.getBeers()
}