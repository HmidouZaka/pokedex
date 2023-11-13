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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class DescriptionsPage : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShowcasePage()
        }
    }
    @Composable
    fun ShowcasePage() {
        var selectedGender by remember { mutableStateOf(Gender.NONE) }

        val maleColor = Color.Blue
        val femaleColor = Color(0xFFFF69B4) // Pink doesn't exist inside Color lol.

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        when (selectedGender) {
                            Gender.MALE -> maleColor
                            Gender.FEMALE -> femaleColor
                            else -> Color.Transparent //Or grey depends on logic.
                        }
                    ),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                GenderIcon(
                    imageResId = R.drawable.img_filter,
                    selectedGender = Gender.MALE,
                    onGenderSelected = { selectedGender = it }
                )
                Spacer(modifier = Modifier.width(16.dp))  //Security measure so they don't fatfinger the wrong button.
                GenderIcon(
                    imageResId = R.drawable.img_filter,
                    selectedGender = Gender.FEMALE,
                    onGenderSelected = { selectedGender = it }
                )
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
                    shape = CircleShape
                )
        )
    }
}

enum class Gender {
    MALE, FEMALE, NONE // None because some rare exist. Maybe gray should be added.
}

@Composable
@Preview(showBackground = true)
fun PokemonShowcasePreview() {
    DescriptionsPage()
}