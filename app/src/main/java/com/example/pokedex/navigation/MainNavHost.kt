package com.example.pokedex.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.ShowcasePage

import com.example.pokedex.UserInterface.BottomBar
import com.example.pokedex.UserInterface.Favorites
import com.example.pokedex.UserInterface.FilterPage
import com.example.pokedex.UserInterface.FilterPageContent
import com.example.pokedex.UserInterface.homePage
import com.example.pokedex.UserInterface.SearchPageFun

import com.example.pokedex.viweModel.searchPageViewModel


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel = viewModel<searchPageViewModel>()

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