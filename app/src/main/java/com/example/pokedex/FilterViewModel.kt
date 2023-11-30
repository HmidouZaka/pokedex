package com.example.pokedex

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pokedex.UserInterface.SortOption

// ViewModel
class FilterViewModel : ViewModel() {
    private val _selectedSortOption = mutableStateOf<SortOption?>(null)
    val selectedSortOption: State<SortOption?> = _selectedSortOption

    fun setSortOption(sortOption: SortOption?) {
        _selectedSortOption.value = sortOption
    }
}

