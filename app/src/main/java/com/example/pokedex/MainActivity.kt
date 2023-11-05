package com.example.pokedex
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Ro
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    DemoScreen()

                }
            }
        }
    }


    @Composable
    fun SearchButton(isOn: Boolean, onClick: () -> Unit) {
        val context = LocalContext.current
        //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
        val intent = Intent(context, SearchPage::class.java)

        Button(onClick = onClick) {

            if (isOn) {
                startActivity(context, intent, null)
            } else {
                Text("🔍")
            }
        }
    }

    @Composable
    fun FilterButton(isOn: Boolean, onClick: () -> Unit) {
        val context = LocalContext.current
        val intent = Intent(context, FilterPage::class.java)
        Button(onClick = onClick) {
            if (isOn) {
                startActivity(context, intent, null)
                Text(text = "Off")
            } else {
                Text("On")
            }
        }
    }

    @Composable
    fun DemoScreen() {
        var isSearchButtonOn by remember { mutableStateOf(false) }
        var isFilterButtonOn by remember { mutableStateOf(false) }

        Box(Modifier.fillMaxSize(), Alignment.TopCenter) {
            SearchButton(isSearchButtonOn) {
                isSearchButtonOn = !isSearchButtonOn
            }
        }
        Box(Modifier.fillMaxSize(), Alignment.TopEnd) {
            FilterButton(isFilterButtonOn) {
                isFilterButtonOn = !isFilterButtonOn
            }
        }
    }
}


@Preview
@Composable
fun homePagefun() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(71.dp))
            Text(
                text = "Pokédex",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(81.dp))
            Image(painter = painterResource(id = R.drawable.img_filter),
                contentDescription = "filter", modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(34.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")



        }
        PokemonList()

    }}
@Composable
fun PokemonList() {
    val Pokemons = PokemonProducer()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        Pokemons.chunked(2) { chunkedPokemons ->
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(chunkedPokemons) { pokemon ->
                        pokemonBox(modifier = Modifier)
                    }
                }
            }
        }
    }
}
@Composable
fun PokemonBoxPreview() {
    pokemonBox(
        modifier = Modifier
            .width(17.dp)
            .height(213.97.dp)
            .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(size = 10.dp))
    )
}

@Composable
fun pokemonBox(modifier: Modifier) {
    Box(
        modifier = modifier
            .width(195.dp)
            .height(178.dp)
            .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(size = 10.dp))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
                ,
                color = Color.Black
            )
            .padding(1.dp)

    ) {
         val rudaFontFamily = FontFamily(
            Font(R.font.ruda_black, FontWeight.W300),
            Font(R.font.ruda_regular, FontWeight.W400),
            Font(R.font.ruda_medium, FontWeight.W500),
            Font(R.font.ruda_bold, FontWeight.W600)
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "#0025",
                fontSize = 12.sp,
                fontFamily = rudaFontFamily,
                fontWeight = FontWeight.W400,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Row(
                modifier = Modifier
                    .padding(start = 7.dp, end = 7.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Pokemon",
                    fontSize =22.sp,
                    fontFamily = rudaFontFamily,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Start)
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Icon",
                    modifier=Modifier.size(25.dp)

                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "Test",
                    modifier = Modifier.fillMaxSize()
                )
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Icon",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(22.dp)
                )
            }
        }
    }
}