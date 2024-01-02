package com.example.pokedex.ui.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.screens.ShowcasePage

import com.example.pokedex.ui.screens.BottomBar
import com.example.pokedex.ui.screens.Favorites
import com.example.pokedex.ui.screens.FilterPageContent
import com.example.pokedex.ui.screens.homePage
import com.example.pokedex.ui.screens.SearchPageFun
import com.example.pokedex.utils.Route

import com.example.pokedex.viweModel.SearchPageViewModel


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel = viewModel<SearchPageViewModel>()

    NavHost(
        navController = navController,
        startDestination = Route.POKEDEX.path,
        modifier = modifier
    ) {
        composable(Route.POKEDEX.path) {
           homePage(navController,viewModel)
        }
        composable(Route.Search.path) {
            SearchPageFun(navController,viewModel )
        }
        composable(Route.FAVORITES.path) {
           Favorites(navController, viewModel)
        }
        composable(Route.Filter.path) {
            FilterPageContent()
        }
        composable(Route.Pokemon.path)
            {
                ShowcasePage(navController, viewModel)
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navStart() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
        MainNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}