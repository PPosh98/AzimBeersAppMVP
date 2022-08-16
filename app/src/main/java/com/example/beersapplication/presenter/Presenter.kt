package com.example.beersapplication.presenter


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.beersapplication.api.FetchAPI
import com.example.beersapplication.model.Beers
import com.example.beersapplication.repository.Repository
import com.example.beersapplication.roomdb.BeerEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class Presenter @Inject constructor(val repository: Repository): PresenterInterface {
    var _beersLiveData: MutableLiveData<Beers> = MutableLiveData(Beers())

    val readBeers: LiveData<List<BeerEntity>> = repository.localData.readBeersFromDb().asLiveData()

    override fun getBeersFromApi() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.remoteData.fetchAPI.getBeers()
            Log.i("Data", response.body().toString())
            if(response.isSuccessful){
                response.body().let {
                    addDataToDatabase(it!!)
                    _beersLiveData.postValue(response.body())
                }
            }
        }
    }

    override fun getBeersObserverDB() = readBeers
    override fun getBeersObserverAPI() = _beersLiveData

    fun addDataToDatabase(beers: Beers) {

        val beersEntity = BeerEntity(beers)
        insertBeers(beersEntity)
    }
    private fun insertBeers(beersEntity: BeerEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.localData.insertBeersIntoDb(beersEntity)
        }
    }
}




