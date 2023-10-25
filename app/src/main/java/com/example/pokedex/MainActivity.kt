package com.example.pokedex
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.Button
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.theme.PokedexTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.core.content.ContextCompat.startActivity

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
                    Greeting("GUYS")
                    DemoScreen()

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
        //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
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

}


