package com.example.testdos.data.remote.api

import com.example.testdos.data.remote.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): CharacterResponse
}
