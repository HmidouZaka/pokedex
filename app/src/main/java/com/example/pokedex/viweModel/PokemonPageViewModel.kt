package com.example.pokedex.viweModel

import androidx.lifecycle.ViewModel
import com.example.pokedex.Pokemon
import com.example.pokedex.R

//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

class searchPageViewModel : ViewModel() {

    var Pokemons: MutableList<Pokemon> = mutableListOf(
      Pokemon("Charmander", R.drawable.img_1),
      Pokemon("Bulbasaur", R.drawable.img_2),
      Pokemon("Squirtle", R.drawable.img_3),
      Pokemon("Jigglypuff", R.drawable.img_4),
      Pokemon("Eevee", R.drawable.img_5),
      Pokemon("Meowth", R.drawable.img_6),
      Pokemon("Snorlax", R.drawable.img_7),
    )
    private set

    fun getMockData(): List<Pokemon> {
        return Pokemons
    }




}