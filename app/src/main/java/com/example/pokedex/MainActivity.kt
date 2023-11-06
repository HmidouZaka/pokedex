package com.example.pokedex
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.navigation.MainNavHost
import com.example.pokedex.navigation.Route
import com.example.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PokedexTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("GUYS")
                    homePagefun()

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
/*
    @Composable
    fun DemoScreen() {
        var isSearchButtonOn by remember { mutableStateOf(false) }
        var isFilterButtonOn by remember { mutableStateOf(false) }

                    homePagefun()
                }
            }
        }
    }

 */




@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
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
                .height(96.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(71.dp))
            Text(
                text = "Pokédex",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(81.dp))
            Image(
                painter = painterResource(id = R.drawable.img_filter),
                contentDescription = "filter", modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(34.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")
        }

    }
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



@Composable
fun BottomBar(navController: NavController) {
    NavigationBar {
        val tabs = listOf(
            Tab(
                title = "Pokedex",
                icon = Icons.Default.List,
                rootRoute = Route.POKEDEX
            ),
            Tab(
                title = "Favorites",
                icon = Icons.Default.Favorite,
                rootRoute = Route.FAVORITES
            )
        )

        val isFavoritesTabSelected = navController.currentBackStack
            .collectAsState()
            .value
            .any { it.destination.route == Route.FAVORITES.path }

        tabs.forEach { tab ->
            val isTabSelected = if (tab.rootRoute == Route.POKEDEX) {
                !isFavoritesTabSelected
            } else {
                isFavoritesTabSelected
            }

            NavigationBarItem(
                icon = {
                    Icon(imageVector = tab.icon, contentDescription = null)
                },
                label = { Text(text = tab.title) },
                selected = isTabSelected,
                onClick = {
                    navController.navigate(route = tab.rootRoute.path) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
private data class Tab(
    val title: String,
    val icon: ImageVector,
    val rootRoute: Route
)


