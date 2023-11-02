package com.example.pokedex

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.ui.Modifier
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
    val context = LocalContext.current // Get the current context(CLASS)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), true, null, true)
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
fun TypeShowcase(): List<Type> {
    var typeIcon: MutableList<Type> = mutableListOf()
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type( R.drawable.img_1))
    typeIcon.add(Type(R.drawable.img_2))
    typeIcon.add(Type(R.drawable.img_3))
    typeIcon.add(Type(R.drawable.img_4))
    typeIcon.add(Type(R.drawable.img_5))
    typeIcon.add(Type( R.drawable.img_6))
    typeIcon.add(Type( R.drawable.img_7))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    typeIcon.add(Type(R.drawable.img))
    return typeIcon
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            val types = listOf(
                R.drawable.bug,R.drawable.dark,R.drawable.dragon,R.drawable.electric,R.drawable.fairy,
                R.drawable.fighting,R.drawable.fire,R.drawable.flying,R.drawable.ghost,R.drawable.grass,
                R.drawable.ground,R.drawable.ice,R.drawable.normal,R.drawable.poison,R.drawable.psychic,R.drawable.rock,
                R.drawable.steel,R.drawable.water
            )


            val columnsPerRow = 6 //18types/3 per row = 6


            //val groupedTypePic = TypeShowcase().chunked(columnsPerRow)
            val groupedTypes = types.chunked(columnsPerRow)

            groupedTypes.forEach { columnTypes ->
                Column {
                    val typeIterator = types.asSequence().iterator()
                    columnTypes.forEach { type ->
                        val resourceId = typeIterator.next()
                        Image(painter = painterResource(id = resourceId),
                            contentDescription = type.toString(),
                             modifier = Modifier
                                .size(128.dp))

                     //  TypeItemButton(type)
                    }
                }
            }
        }
    }
}

private fun <E> MutableList<E>.add(element: Type) {

}

@Composable
fun TypeItemButton(type: Type) {
    Button(
        onClick = {
            // Hver button click kan handles her senere, måske for loop er smart. Skal lige finde system.
        },
        modifier = Modifier
            .padding(4.dp)
    ) {

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