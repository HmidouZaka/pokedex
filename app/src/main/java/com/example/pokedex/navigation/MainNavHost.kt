package com.example.pokedex.navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.ShowcasePage
import com.example.pokedex.UserInterface.BottomBar
import com.example.pokedex.UserInterface.Favorites
import com.example.pokedex.UserInterface.homePage


@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Route.POKEDEX.path,
        modifier = modifier
    ) {
        composable(Route.POKEDEX.path) {
           homePage(navController)
        }
        composable(Route.FAVORITES.path) {
           Favorites()
        }
        composable(
            route = Route.Pokemon.path+"/{name}"
        ,arguments =
        listOf(
            navArgument("name"){
                type = NavType.StringType
                defaultValue = "Pikachu"
                nullable = true
            }
        )
        ) {entry ->


            val stringVal = entry.arguments?.getString("name") ?: "Pikachu"
            ShowcasePage(navController, stringVal)

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