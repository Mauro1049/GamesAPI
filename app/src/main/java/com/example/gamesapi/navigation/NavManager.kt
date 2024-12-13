package com.example.gamesapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamesapi.viewmodel.GameViewModel
import com.example.gamesapi.views.DetailsView
import com.example.gamesapi.views.HomeView
import com.example.gamesapi.views.SearchGameView

@Composable
fun NavManager(viewModel: GameViewModel){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home"){
        composable("Home") {
            HomeView(viewModel, navController)
        }
        composable("DetailsView") {
            DetailsView()
        }
        composable("SearchGameView") {
            SearchGameView()
        }
    }
}