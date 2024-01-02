package com.example.pokedex.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pokedex.ui.screens.SortOption

// ViewModel
class FilterViewModel : ViewModel() {
    private val _selectedSortOption = mutableStateOf<SortOption?>(null)
    val selectedSortOption: State<SortOption?> = _selectedSortOption

    fun setSortOption(sortOption: SortOption?) {
        _selectedSortOption.value = sortOption
    }
}

