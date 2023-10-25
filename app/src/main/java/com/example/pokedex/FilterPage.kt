package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    var selectedGeneration by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(),true,null,true)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow")
            Text(
                text = "Filter Options",
                fontSize = 20.sp
            )
        }
        TypeButton(
            // Type Button tilføjes her senere.
        )

        Spacer(modifier = Modifier.height(16.dp))
//Vi laver lige 9 knapper via et for loop for generation, det er derfor names ik er med.
        for (generation in 1..9) {
            GenerationButton(
                generation = generation,
                selectedGeneration = selectedGeneration,
                onGenerationSelected = { selectedGeneration = it }
            )

            if (selectedGeneration == generation) {
                GenerationNameList(generation = generation)
            }
        }

    }
}

@Composable
fun TypeButton() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Type")
    }
}

@Composable
fun GenerationButton(
    generation: Int,
    selectedGeneration: Int,
    onGenerationSelected: (Int) -> Unit
) {
    Button(
        onClick = { onGenerationSelected(generation) },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Generation $generation")
        //Her er $generation det samme som et normal 1 som bare tæller op List.
    }
}

@Composable
fun GenerationNameList(generation: Int) {
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
        modifier = Modifier.padding(16.dp),
    ) {
        namesForGeneration.forEach { name ->
            Text(text = name, fontSize = 16.sp)
        }
    }
}
