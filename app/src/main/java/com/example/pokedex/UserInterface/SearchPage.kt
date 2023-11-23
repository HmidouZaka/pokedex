package com.example.pokedex.UserInterface

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import coil.compose.AsyncImage
import com.example.pokedex.MainActivity
import com.example.pokedex.Pokemon
import com.example.pokedex.PokemonObject
import com.example.pokedex.R
import com.example.pokedex.viweModel.searchPageViewModel

class SearchPage : ComponentActivity(){
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_searchpage)
    setContent {
            SearchPageFun()



        }



    }





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPageFun() {
    var name by remember { mutableStateOf("") }
    val viewmodel = searchPageViewModel()
    val Pokemons= viewmodel.Pokemons
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

                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow",
                  modifier =  Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    })


            TextField (
                value = name,
                onValueChange = { text -> name = text },
                 modifier = Modifier.weight(1f),

               placeholder = {Text (text = "Search your Pokemon") }
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

        Pokemonlists(PokemonObject.pokeList)
    }
}

@Composable
fun Pokemonlists(pokeList:List<Pokemon>
                 ,modifier: Modifier = Modifier
) {


    LazyColumn() {


        item {
            Spacer(modifier = Modifier.height(39.dp))
        }
        items(pokeList) { currentPokemon ->

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
                    AsyncImage(
                        model = currentPokemon.pictureURL,
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

}

