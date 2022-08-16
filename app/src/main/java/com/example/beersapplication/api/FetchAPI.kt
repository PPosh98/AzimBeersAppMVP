package com.example.beersapplication.api

import com.example.beersapplication.model.Beers
import retrofit2.Response
import retrofit2.http.GET

interface FetchAPI {

    @GET("beers?page=2&per_page=20")
    suspend fun getBeers(): Response<Beers>
}