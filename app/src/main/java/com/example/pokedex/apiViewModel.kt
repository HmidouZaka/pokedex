package com.example.pokedex

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import kotlinx.coroutines.*
import java.net.URL
import org.json.JSONObject

class ApiViewModel: ViewModel() {
//    load image
    //imageView.load("https://example.com/image.jpg")

  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  fun addPokemon(start:Int, end:Int, onlyDefaults:Boolean, cleanCopy:Boolean){
        viewModelScope.launch(Dispatchers.IO){
//            val fileName = "json/pokemonCache.json"
//            var file = File(fileName)
//            var cacheJson = JSONObject(file.readText())
            val limit = start+end
//            val jsonData =URL("https://pokeapi.co/api/v2/pokemon?limit=$limit&offset=$start").readText()
//            val pokemonJson = JSONObject(jsonData)
            var i : Int = start

            while(i <= end){
////            if(cleanCopy and (!cacheJson.has("$i"))) {
//
                val jsonData2 = URL("https://pokeapi.co/api/v2/pokemon/$i").readText()
////            }
                var pokemonJson2  = JSONObject(jsonData2)
//
                if (pokemonJson2.getBoolean("is_default") or !onlyDefaults) {
                    var pokeName: String =
                        pokemonJson2.getString("name")
                    var pokeId: Int =
                        pokemonJson2.getInt("id")
                    var pokeDefaultPictureFront: String =
                        pokemonJson2.getJSONObject(
                            "sprites"
                        ).getJSONObject("other").getJSONObject("official-artwork").getString("front_default")
                    Log.d("info",""+pokeName+" "+pokeDefaultPictureFront+" "+ pokeId)
                    PokemonObject.pokeList.add(Pokemon(pokeName, pokeDefaultPictureFront, pokeId))
//                cacheJson.put(""+pokeId,pokeName)
                }

                i++
        }

        }

    }}



