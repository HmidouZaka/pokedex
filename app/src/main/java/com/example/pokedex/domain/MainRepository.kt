package com.example.pokedex.domain

import com.example.pokedex.data.remote.PokemonData

class MainRepository(
    private val pokemonData: PokemonData
) {


    suspend fun addPokemon(start: Int, end: Int, onlyDefaults: Boolean, cleanCopy: Boolean){
        pokemonData.addPokemon(start, end, onlyDefaults, cleanCopy)
    }


}