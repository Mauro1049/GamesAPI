package com.example.gamesapi.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamesapi.components.CardGame
import com.example.gamesapi.components.MainTopBar
import com.example.gamesapi.viewmodel.GameViewModel

@Composable
fun HomeView(viewModel: GameViewModel, navController: NavController){
    Scaffold (
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton = { /*TODO*/ }) {
                navController.navigate("SearchGameView")
            }
        }
    ){
        ContentHomeView(viewModel, paddingValues = it, navController)
    }
}

@Composable
fun ContentHomeView(viewModel: GameViewModel, paddingValues: PaddingValues, navController: NavController){
    val games by viewModel.games.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ){
        items(games){ item ->
            CardGame(item) {
                navController.navigate("DetailsView")
            }
            Text(
                text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
    }

}