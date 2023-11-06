package com.example.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedex.favorites_screen.Favorites
import com.example.pokedex.homePagefun


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Route.POKEDEX.path,
        modifier = modifier
    ) {
        composable(Route.POKEDEX.path) {
            //homePagefun()
        }
        composable(Route.FAVORITES.path) {
           Favorites()
        }
    }
}