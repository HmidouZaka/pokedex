package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val Pokemons= PokemonProducer()
    val context = LocalContext.current // Get the current context

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(243, 237, 247))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0), RoundedCornerShape(15.dp))
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.clickable {

                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow")
            }

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

        Pokemonlists(Pokemons)
    }
}

@Composable
fun Pokemonlists(Pokemons:List<Pokemon>
                 ,modifier: Modifier = Modifier
) {


    LazyColumn() {

        item {
            Spacer(modifier = Modifier.height(39.dp))
        }
        items(Pokemons) { currentPokemon ->

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {



                Spacer(modifier = Modifier.width(16.dp))
                Box (modifier = Modifier
                    .background(Color.Transparent, CircleShape)
                    .border(
                        width = 1.dp,
                        color = Color(0, 0, 0, 20),
                        shape = CircleShape
                    )
                    .size(64.dp)


                ) {
                    Image(
                        painter = painterResource(id = currentPokemon.picture),
                        contentDescription = "currentPokemon",
                        alignment = Alignment.Center,
                        modifier= Modifier
                            .background(Color.Transparent)
                            .size(64.dp)
                            .clip(shape = CircleShape)

                    )


                }

                Spacer(modifier.width(25.02.dp))

                Text(
                    text = currentPokemon.name,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default

                )

            }
            Spacer(modifier.height(39.dp))

        }
    }
}
@Composable
fun PokemonProducer(): List<Pokemon> {
    var Pokemons: MutableList<Pokemon> = mutableListOf()
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    Pokemons.add(Pokemon("Charmander", R.drawable.img_1))
    Pokemons.add(Pokemon("Bulbasaur", R.drawable.img_2))
    Pokemons.add(Pokemon("Squirtle", R.drawable.img_3))
    Pokemons.add(Pokemon("Jigglypuff", R.drawable.img_4))
    Pokemons.add(Pokemon("Eevee", R.drawable.img_5))
    Pokemons.add(Pokemon("Meowthe", R.drawable.img_6))
    Pokemons.add(Pokemon("Snorlax", R.drawable.img_7))
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    Pokemons.add(Pokemon("Pikachu", R.drawable.img))
    return Pokemons
}