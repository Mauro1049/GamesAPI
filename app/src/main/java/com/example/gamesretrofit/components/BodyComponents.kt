package com.example.gamesretrofit.components

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore.Images
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.gamesretrofit.model.GameList

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
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF2B2626)
        ),
        navigationIcon = {
            if(showBackButton){
                IconButton(onClick = {onClickBackButton()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        },
        actions = {
            if(!showBackButton){
                IconButton(onClick = {onClickAction()}) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }
            }
        }
    )
}

@Composable
fun CardGame(game: GameList, onClick:()-> Unit){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            MainImage(image = game.background_image)
        }
    }
}

@Composable
fun MainImage(image : String){
    val image = rememberImagePainter(data = image)

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    )
}

@Composable
fun MetaWebSite(url : String){

    val context = LocalContext.current
    val intent = Intent(
        Intent.ACTION_VIEW, Uri.parse(url)
    )

    Column {
        Text(
            text = "METASCORE",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
        )
        Button(
            onClick = { context.startActivity(intent) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Gray
            )
        ) {
            Text(text = "Sitio Web")
        }
    }
}

@Composable
fun ReviewCard(metascore : Int){
    Card(
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF209B14),
        )
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = metascore.toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp
            )
        }
    }
}