package com.example.pokedex



import android.app.Activity
import android.content.Context
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
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokedex.viweModel.searchPageViewModel

    @Composable
    fun ShowcasePage(navHostController: NavHostController,viewModel: searchPageViewModel) {
        val context = LocalContext.current
        var selectedGender by remember { mutableStateOf(Gender.NONE) }
        val pokemon = viewModel.getPokemon()
        val maleColor = Color(49,59,169)
        val femaleColor = Color(143,68,124)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState(),true)
        ) {
            // Top Baren folkens!
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent) }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.width(14.dp))
                //Texten skal retrieve en string fra PokeAPI'en.

                pokemon?.let {
                    Text(
                        text = it.name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Divider(
                color = Color.Black,
                thickness = 1.5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        when (selectedGender) {
                            Gender.MALE -> maleColor
                            Gender.FEMALE -> femaleColor
                            else -> Color.Transparent // Or grey depends on logic.
                        }
                    )
            ) {
                if (pokemon != null) {
                    AsyncImage(
                        model = pokemon.pictureURL,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp),
                        contentScale = ContentScale.Crop
                    )


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.BottomStart)
                ) {
                 //RYK GENDERICONS og Favorite ICON HER SÅ DET BLIVER IN PICTURE som FIGMA
                    ////////////////////////////////////////////////////
                    Spacer(modifier = Modifier.width(16.dp))

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                GenderIcon(
                    imageResId = R.drawable.male,
                    selectedGender = Gender.MALE,
                    onGenderSelected = { selectedGender = it }
                )

                GenderIcon(
                    imageResId = R.drawable.female,
                    selectedGender = Gender.FEMALE,
                    onGenderSelected = { selectedGender = it }
                )
                Spacer(modifier = Modifier.weight(1f))

                var isFavorite by remember { mutableStateOf(false) }
                ///Hello fix fra aisha
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.pokeball_bw),
                        contentDescription = "Favorite option",
                        tint = if (isFavorite) Color.Red else Color.Black,
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { isFavorite = !isFavorite }
                            .requiredSize(36.dp, 36.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
            Divider(
                color = Color.Black,
                thickness = 1.5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(220.dp)
                    .background(Color.LightGray)
                    .clip(CircleShape)
            ) {
                if (pokemon != null) {
                    Text(
                        text = pokemon.pokedexText[0],
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterStart),
                        color = Color.White
                    )
                }
            }
        }
    }
    @Composable
    fun GenderIcon(
        imageResId: Int,
        selectedGender: Gender,
        onGenderSelected: (Gender) -> Unit
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clickable { onGenderSelected(selectedGender) }
                .border(
                    width = 2.dp,
                    color = if (selectedGender != Gender.NONE) Color.White else Color.Transparent,
                )
        )
    }


enum class Gender {
    MALE, FEMALE, NONE // None because some rare exist. Maybe gray should be added.
}

@Composable
@Preview(showBackground = true)
fun PokemonShowcasePreview() {
}