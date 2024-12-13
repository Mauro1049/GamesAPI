package com.example.gamesretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.gamesretrofit.navigation.NavManager
import com.example.gamesretrofit.ui.theme.GamesRetroFitTheme
import com.example.gamesretrofit.viewmodel.GamesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : GamesViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            GamesRetroFitTheme {
                NavManager(viewModel)
            }
        }
    }
}
