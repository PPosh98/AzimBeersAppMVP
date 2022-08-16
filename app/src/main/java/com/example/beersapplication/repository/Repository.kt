package com.example.beersapplication.repository

import com.example.beersapplication.model.Beers
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
    ) {

    val remoteData = remoteDataSource
    val localData = localDataSource
}