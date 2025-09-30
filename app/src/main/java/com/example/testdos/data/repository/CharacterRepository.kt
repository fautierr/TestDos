package com.example.testdos.data.repository

import com.example.testdos.data.remote.api.RetrofitInstance

class CharacterRepository {
    private val api = RetrofitInstance.api

    suspend fun getCharacters(page: Int = 1) = api.getCharacters(page)
}
