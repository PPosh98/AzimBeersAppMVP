package com.example.beersapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.beersapplication.R
import com.example.beersapplication.databinding.ActivityMainBinding
import com.example.beersapplication.model.Beers
import com.example.beersapplication.utils.NetworkListener
import com.example.beersapplication.utils.observeOnce
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val beersViewModel : BeersViewModel by lazy{
        ViewModelProvider(this).get(BeersViewModel::class.java)
    }
    val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var networkListener: NetworkListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            networkListener = NetworkListener()
            networkListener.checkNetworkAvailability(applicationContext)
                .collect { status ->
                    Log.i("NetworkListener", status.toString())
                    readDatabase()

                }
        }

        setContentView(binding.root)
    }

    private fun readDatabase() {
        lifecycleScope.launch {
            beersViewModel.readBeers.observeOnce(this@MainActivity) { database ->
                if (database.isNotEmpty()) {
                    Log.i("database", "readDatabase called!")
                    Log.i("database", database[0].beerEntityModel.toString())
                    updateUI(database[0].beerEntityModel)
                } else {
                    getBeers()
                }
            }
        }
    }

    private fun getBeers() {
        beersViewModel.getBeers()
        beersViewModel._beersLiveData.observe(this){
            beers -> updateUI(beers as Beers)
        }
    }

    private fun updateUI(beers: Beers) {
        var text = ""
        for (beer in beers) {
            text += "${beer.id} -> ${beer.name}\n"
        }

        binding.tvBeers.text = text
    }
}