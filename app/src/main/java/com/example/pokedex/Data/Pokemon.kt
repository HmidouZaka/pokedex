package com.example.pokedex.Data
import android.util.Log
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import java.net.URL

 data class Pokemon(
  val name: String,
  val pictureURL: String,
  val id: Int,
  val type1: String,
  val type2: String,
  val pokedexText: ArrayList<String>
 )