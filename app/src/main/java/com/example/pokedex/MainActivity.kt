package com.example.pokedex


import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SearchPage()

        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchPage() {
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
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow")

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
fun Pokemonlists(Pokemons:List<String>
                 ,modifier: Modifier =Modifier){
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

@Composable
fun filterPage(){
    Column ( modifier = Modifier
        .fillMaxSize()
    ) {




        Row (modifier = Modifier
            .fillMaxWidth()
            .height(38.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow")

            Text(text = "Filter Options",
                fontSize =20.sp)




        }
    }



}


