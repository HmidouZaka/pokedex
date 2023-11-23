package com.example.pokedex.viweModel

import androidx.lifecycle.ViewModel
import com.example.pokedex.Pokemon
import com.example.pokedex.PokemonObject
import com.example.pokedex.R
import kotlinx.coroutines.flow.MutableStateFlow

//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

class searchPageViewModel : ViewModel() {
    private var selectedPokemon: Pokemon = PokemonObject.pokeList[0]
    var PokemonsFave = PokemonObject.faveList

    var Pokemons = PokemonObject.pokeList


    fun getMockData(isFavorite:Boolean): List<Pokemon> {
        if (!isFavorite)
        return Pokemons
        else return PokemonsFave
    }

    fun getPokemon():Pokemon{
        return selectedPokemon
    }
    fun setPokemon(pokemon: Pokemon){
      selectedPokemon = pokemon
    }







}
