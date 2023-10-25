package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

class SearchPage : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_searchpage)
        setContent {
            SearchPageFun()
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun SearchPageFun() {
        var name by remember { mutableStateOf("Search your Pokemon") }
        var Pokemons: MutableList<String> = mutableListOf()

        Pokemons.add(0, "PokemonNames")

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray, RoundedCornerShape(15.dp))
                    .height(38.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow",modifier = Modifier.clickable {

                })

                BasicTextField(
                    value = name,
                    onValueChange = { text -> name = text },
                    modifier = Modifier.weight(1f)
                )

                if (name.isNotBlank()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear",
                        modifier = Modifier.clickable {
                            name = ""
                        }
                    )
                }
            }

            Pokemonlists(Pokemons = Pokemons)
        }
    }
@Composable
fun Backarrow() {
    val context = LocalContext.current
    val intent = Intent(context, MainActivity::class.java)
    ContextCompat.startActivity(context, intent, null)
}

    @Composable
    fun Pokemonlists(Pokemons:List<String>
                     ,modifier: Modifier = Modifier
    ){
        LazyColumn {
            items (Pokemons){ currentPokemon ->
                Row() {
                    Icon(imageVector = Icons.Default.Face , contentDescription ="Pokemon pictures" )

                    Text(
                        text = currentPokemon)
                    Divider()
                }

            }

        }

    }
