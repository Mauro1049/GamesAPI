package com.example.gamesretrofit.repository

import com.example.gamesretrofit.data.GameApi
import com.example.gamesretrofit.model.GameList
import com.example.gamesretrofit.model.SingleGameModel
import javax.inject.Inject

class GamesRepository @Inject constructor(private val gamesApi : GameApi) {

    suspend fun getGames():List<GameList>?{
        val response = gamesApi.getGames()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }

    suspend fun getGameById(id : Int): SingleGameModel?{
        val response = gamesApi.getGameById(id)
        if (response.isSuccessful){
            return response.body()
        }
        return null
    }

}