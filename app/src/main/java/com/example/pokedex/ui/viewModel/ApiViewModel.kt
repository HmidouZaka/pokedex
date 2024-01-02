package com.example.pokedex.ui.viewModel

import androidx.lifecycle.*
import com.example.pokedex.domain.MainRepository

import kotlinx.coroutines.*
import java.net.URL
import org.json.JSONObject

class ApiViewModel constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun addPokemon(start: Int, end: Int, onlyDefaults: Boolean, cleanCopy: Boolean) {
        viewModelScope.launch {
            mainRepository.addPokemon(start, end, onlyDefaults, cleanCopy)
        }
    }
}



