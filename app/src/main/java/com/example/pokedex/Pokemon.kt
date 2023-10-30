package com.example.pokedex
import android.util.Log
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import java.net.URL

class Pokemon(globalID : Int)  {
    var name : String = "hej"

    init {
        fun thread(){
            Log.d("info",(URL("https://pokeapi.co/api/v2/pokemon/$globalID").readText()))

        }


        }
//        var jsonObject = Json.parseToJsonElement((URL("https://pokeapi.co/api/v2/pokemon/$globalID").readText()))
//        Log.d("info",jsonObject.getString("species"))
    }

