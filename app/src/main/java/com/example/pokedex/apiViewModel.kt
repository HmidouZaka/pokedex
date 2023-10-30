package com.example.pokedex

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import java.net.URL
import kotlinx.serialization.*
import org.json.JSONObject

class ApiViewModel: ViewModel() {
//    load image
    //imageView.load("https://example.com/image.jpg")

  fun addPokemon(start:Int,end:Int){
        viewModelScope.launch(Dispatchers.IO){
            val limit = end + start
            val jsondata = URL("https://pokeapi.co/api/v2/pokemon?limit=$limit&offset=$start").readText()
            val pokemonJson =JSONObject(jsondata)
            var i : Int = 0
            while(i < pokemonJson.getInt("count")){
            Log.d("name" ,JSONObject(pokemonJson.getJSONArray("results")[i].toString()).getString("name"))
                i++
        }}
    }}



