package com.example.beersapplication.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.beersapplication.model.Beers
import com.example.beersapplication.roomdb.BeerEntity
import retrofit2.Response

interface PresenterInterface {
    fun getBeersFromApi()
    fun getBeersObserverDB() : LiveData<List<BeerEntity>>
    fun getBeersObserverAPI() : MutableLiveData<Beers>
}