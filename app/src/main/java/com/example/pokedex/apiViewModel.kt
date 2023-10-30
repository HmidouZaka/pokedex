package com.example.pokedex

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import java.net.URL
import kotlinx.serialization.*
class ApiViewModel: ViewModel() {
//    load image
    //imageView.load("https://example.com/image.jpg")

  fun addPokemon(start:Int,end:Int){
        viewModelScope.launch(Dispatchers.IO){
            val limit = end + start
            URL("https://pokeapi.co/api/v2/pokemon?limit=$limit&offset=$start")
        }}
    }



