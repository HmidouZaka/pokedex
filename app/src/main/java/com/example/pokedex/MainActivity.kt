package com.example.pokedex

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Data().createPokemons(1,10)

        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("GUYS")
                    DemoScreen()
                }
            }
        }

    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun DemoScreen() {
    var isOn by remember {
        mutableStateOf(false)
    }

    Box(Modifier.fillMaxSize(), Alignment.TopCenter) {
        //Box(modifier = Modifier.size(40.dp), Alignment.TopCenter) {
        SearchButton(isOn) {
            isOn = !isOn
        }
    }
        Box(Modifier.fillMaxSize(), Alignment.TopEnd) {
        FilterButton(isOn) {
            isOn = !isOn
        }
    }
}
@Composable
fun SearchButton(isOn: Boolean, onClick: () -> Unit) {

    Button(onClick = onClick) {
        if (isOn) {
            Text(text = "Off")
        } else {
            Text("🔍")
        }
    }
}

@Composable
fun FilterButton(isOn: Boolean, onClick: () -> Unit) {

    Button(onClick = onClick) {
        if (isOn) {
            Text(text = "Off")
        } else {
            Text("On")
        }
    }
}
