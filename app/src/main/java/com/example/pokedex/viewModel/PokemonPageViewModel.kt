package com.example.pokedex.viewModel

import androidx.lifecycle.ViewModel
import com.example.pokedex.Pokemon
import com.example.pokedex.PokemonObject

//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

class searchPageViewModel : ViewModel() {
    private var selectedPokemon: Pokemon = PokemonObject.pokeList[0]

    var Pokemons = PokemonObject.pokeList


    fun getMockData(): List<Pokemon> {
        return Pokemons
    }

    fun getPokemon():Pokemon{
        return selectedPokemon
    }
    fun setPokemon(pokemon: Pokemon){
      selectedPokemon = pokemon
    }







}
