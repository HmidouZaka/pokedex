package com.example.pokedex.Presentation.UserInterface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R


@Preview
@Composable
fun pokemonPage(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        ){
            Text(text = "", modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.weight(4f))
            EvolutionBar()
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun EvolutionBar(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .offset(x = 10.dp)
    ) {
        Text(
            text = "Evolutions",
            fontSize = 30.sp,
            modifier = Modifier
        )
        DropDownArrowImage()
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    )
    {
        EvolutionCircleImage()
        EvolutionArrowImage()
        EvolutionCircleImage()
        EvolutionArrowImage()
        EvolutionCircleImage()
        /*repeat(3){
            EvolutionCircleImage()
            }*/
    }
}

@Composable
fun EvolutionCircleImage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(110.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.evolutionscircle),
            contentDescription = "Evolution",
            modifier = Modifier.fillMaxSize()
                .size(100.dp),
            //contentScale = ContentScale.Crop
            //modifier = Modifier.size(100.dp)
        )
        EvolutionsPicture()
    }
}


@Composable
fun EvolutionArrowImage(){
    Image(
        painter = painterResource(id = R.drawable.evolutionvector),
        modifier = Modifier
            .size(25.dp)
            .offset(y = 30.dp),
        contentDescription = null
    )
}

@Composable
fun DropDownArrowImage(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.dropdownevolutionvector),
        modifier = Modifier
            .size(25.dp)
            .offset(y = 2.dp),
        contentDescription = null
    )
}
//
@Composable
fun EvolutionsPicture(){
    Image(
        painter = painterResource(id = R.drawable.raichu),
        modifier = Modifier
            .size(65.dp)
            .offset(y = -10.dp)
            .offset(x = 3.dp),
        contentDescription = null
    )
}