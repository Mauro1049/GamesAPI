package com.example.gamesretrofit.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.gamesretrofit.components.CardGame
import com.example.gamesretrofit.components.MainTopBar
import com.example.gamesretrofit.viewmodel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController){
    Scaffold (
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton = { /*TODO*/ }) {
                navController.navigate("SearchGameView")
            }
        }
    ){
        ContentHomeView(viewModel = viewModel, paddingValues = it, navController)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, paddingValues: PaddingValues, navController: NavController){
    val games by viewModel.games.collectAsState()
    LazyRow(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(games){item ->
            CardGame(item) {
                navController.navigate("DetailsView/${item.id}")
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