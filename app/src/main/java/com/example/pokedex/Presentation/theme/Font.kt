package com.example.pokedex.Presentation.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.pokedex.R

class Font {
    companion object{
    val rudaFontFamily = FontFamily(
        Font(R.font.ruda_black, FontWeight.W300),
        Font(R.font.ruda_regular, FontWeight.W400),
        Font(R.font.ruda_medium, FontWeight.W500),
        Font(R.font.ruda_bold, FontWeight.W600)
    )

}}