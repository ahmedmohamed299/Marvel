package com.example.marvel.data.service

import com.example.marvel.data.character.CharacterResponse
import com.example.marvel.data.utils.Constants
import com.example.marvel.data.utils.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApisService {


    @GET(Constants.CHARACTER_END_POINT)
     suspend fun getAllCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String = Constants.limit,
        @Query("offset") offset: String = Constants.offset

    ): ResponseBody<CharacterResponse>

    @GET(Constants.CHARACTER_END_POINT)
    suspend fun getAllSearchedCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("nameStartsWith") search: String
    ): ResponseBody<CharacterResponse>
}