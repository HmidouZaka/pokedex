package com.example.pokedex
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pokedex.ui.theme.PokedexTheme
import kotlinx.coroutines.*
import com.example.pokedex.navigation.navStart
import com.example.pokedex.viweModel.ApiViewModel


object PokemonObject{
    var pokeList = ArrayList<Pokemon>()
    var faveList = ArrayList<Pokemon>()
}


class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApiViewModel().addPokemon(1,1470,true,true)

        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    navStart()
                }
            }
        }

    }
}
