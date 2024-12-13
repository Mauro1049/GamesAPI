package com.example.gamesapi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.gamesapi.model.GameList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title : String,
    showBackButton : Boolean = false,
    onClickBackButton: () -> Unit,
    onClickAction: () -> Unit
){
    TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.Bold) },
        colors =  TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF2B2626)
        ),
        navigationIcon = {
            if(showBackButton){
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        },
        actions = {
            if (!showBackButton) {
                IconButton(onClick = { onClickAction() }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }
            }
        }
    )
}

@Composable
fun CardGame(game : GameList, onClick : () -> Unit){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            MainImage(image = game.background_image)
        }
    }

}

@Composable
fun MainImage(image: String) {
    val image = rememberImagePainter(data = image)

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
