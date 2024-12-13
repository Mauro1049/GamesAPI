package com.example.gamesapi.data

import com.example.gamesapi.model.GamesModel
import com.example.gamesapi.model.SingleGameModel
import com.example.gamesapi.utils.Constants.Companion.API_KEY
import com.example.gamesapi.utils.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): retrofit2.Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id")id : Int): Response<SingleGameModel>


}