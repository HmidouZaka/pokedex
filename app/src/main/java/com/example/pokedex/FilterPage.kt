package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FilterPage : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            filterPage()
        }
    }
    @Composable
    fun filterPage() {
        Column(
            modifier = Modifier
                .fillMaxSize()
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
        }


    }
}
