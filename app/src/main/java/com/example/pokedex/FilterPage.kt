package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
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

    // Selected name maintained globally
    var selectedName by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), true, null, true)
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
        // Vi laver lige 9 knapper via et for loop for generation, det er derfor names ik er med.
        for (generation in 1..9) {
            GenerationButton(
                generation = generation,
                selectedGeneration = selectedGeneration,
                onGenerationSelected = { selectedGeneration = it }
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
        modifier = Modifier.padding(16.dp),
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