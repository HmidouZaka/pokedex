package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class FilterPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FilterPageContent()
        }
    }
}
@Composable
fun FilterPageContent() {
    var selectedGeneration by remember { mutableStateOf(-1) }
    var selectedName by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current // Get the current context(CLASS FOLKS)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), true)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
        ) {
            Box(
                modifier = Modifier.clickable {
                    // Redirect to MainActivity
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow")
            }

            Text(
                text = "Filter Options",
                fontSize = 20.sp
            )
        }

        TypeButton()

        Spacer(modifier = Modifier.height(16.dp))

        for (generation in 1..9) {
            GenerationButton(
                generation = generation,
                selectedGeneration = selectedGeneration,
                onGenerationSelected = {
                    if (selectedGeneration == it) {
                        selectedGeneration = -1
                    } else {
                        selectedGeneration = it
                    }
                },
                isGenerationSelected = selectedGeneration == generation,
                isNameInGeneration = isNameInGeneration(selectedName, generation)
            )

            if (selectedGeneration == generation) {
                GenerationNameList(
                    generation = generation,
                    selectedName = selectedName,
                    onNameSelected = { selectedName = it }
                )
            }
        }
    }
}
@Composable
fun TypeButton() {
    var isMenuVisible by remember { mutableStateOf(true) }

    Button(
        onClick = { isMenuVisible = true },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Type")
    }

    if (isMenuVisible) {
        val types = listOf(
            R.drawable.bug, R.drawable.dark, R.drawable.dragon, R.drawable.electric, R.drawable.fairy,
            R.drawable.fighting, R.drawable.fire, R.drawable.flying, R.drawable.ghost, R.drawable.grass,
            R.drawable.ground, R.drawable.ice, R.drawable.normal, R.drawable.poison, R.drawable.psychic, R.drawable.rock,
            R.drawable.steel, R.drawable.water
        )
        val columnsPerRow = 3 // 18/6 = 3
        val groupedTypes = types.chunked(columnsPerRow)

        Column {
            for (columnTypes in groupedTypes) {
                Row {
                    for (type in columnTypes) {
                        TypeItemButton(type)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun TypeItemButton(type: Int) {
    val isButtonClicked = remember { mutableStateOf(true) }
//Dette design har brug for noget testing med Actionlogs, da det er ikke lige særlig brugervenligt endnu.
    Box(
        modifier = Modifier
            .size(140.dp, 31.dp)
//Size of Type-pics is 140 x 31
            .clickable {
                isButtonClicked.value = !isButtonClicked.value
                Log.d("ButtonClicked fra Type", "Button med type $type er trykket ")
                //Log ID er 21309686[00] til 21309686[18] fra logcat. Seems to work.
               //Prøv nyt box design som clickable, da buttons laver for store designButtons, ud fra fill med 140.dp som width for billede.
            }
    ) {
        Image(
            painter = painterResource(id = type),
            contentDescription = type.toString(),
            modifier = Modifier.fillMaxSize()
                .padding(3.5.dp)
        )
    }
}

@Composable
fun GenerationButton(
    generation: Int,
    selectedGeneration: Int,
    onGenerationSelected: (Int) -> Unit,
    isGenerationSelected: Boolean,
    isNameInGeneration: Boolean
) {
    Button(
        onClick = { onGenerationSelected(generation) },
        modifier = Modifier.padding(16.dp)
    ) {
        //Maybe my memory is like a goldfish, but this memory works!
        val buttonText = "Generation $generation" + if (isNameInGeneration) " ✅" else ""
        Text(text = buttonText)
    }
}

@Composable
fun GenerationNameList(
    generation: Int,
    selectedName: String?,
    onNameSelected: (String) -> Unit
) {
    val namesForGeneration = when (generation) {
        1 -> listOf("Red", "Green", "Blue", "Yellow")
        2 -> listOf("Gold", "Silver", "Crystal")
        3 -> listOf("Ruby", "Sapphire", "Emerald", "FireRed", "LeafGreen")
        4 -> listOf("Diamond", "Pearl", "Platinum", "HeartGold", "SoulSilver")
        5 -> listOf("Black", "White", "Black 2", "White 2")
        6 -> listOf("X", "Y", "Omega Ruby", "Alpha Sapphire")
        7 -> listOf("Sun", "Moon", "Ultra Sun", "Ultra Moon")
        8 -> listOf("Sword", "Shield", "Brilliant Diamond", "Shining Pearl", "Legends: Arceus")
        9 -> listOf("Scarlet", "Violet")
        else -> emptyList()
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        namesForGeneration.forEach { name ->
            val isSelected = name == selectedName
            val textModifier = Modifier
                .clickable {
                    onNameSelected(name)
                }
                .padding(4.dp)
                .background(if (isSelected) Color.Red else Color.Transparent)
            Text(
                text = name,
                modifier = textModifier,
                fontSize = 16.sp,
                color = if (isSelected) Color.White else Color.Black
            )
        }
    }
}


//Laver et memory state, der checker for gens og dens indhold af navn til at rykke checkmarket hen til den generation. RememberState, but fancy.
fun isNameInGeneration(name: String?, generation: Int): Boolean {
    return when (generation) {
        1 -> listOf("Red", "Green", "Blue", "Yellow").contains(name)
        2 -> listOf("Gold", "Silver", "Crystal").contains(name)
        3 -> listOf("Ruby", "Sapphire", "Emerald", "FireRed", "LeafGreen").contains(name)
        4 -> listOf("Diamond", "Pearl", "Platinum", "HeartGold", "SoulSilver").contains(name)
        5 -> listOf("Black", "White", "Black 2", "White 2").contains(name)
        6 -> listOf("X", "Y", "Omega Ruby", "Alpha Sapphire").contains(name)
        7 -> listOf("Sun", "Moon", "Ultra Sun", "Ultra Moon").contains(name)
        8 -> listOf("Sword", "Shield", "Brilliant Diamond", "Shining Pearl", "Legends: Arceus").contains(name)
        9 -> listOf("Scarlet", "Violet").contains(name)
        else -> false
    }
}
//Check Check Git works?