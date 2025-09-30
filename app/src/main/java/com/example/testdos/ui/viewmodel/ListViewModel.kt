package com.example.testdos.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testdos.data.repository.CharacterRepository
import com.example.testdos.data.remote.model.CharacterDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: CharacterRepository = CharacterRepository()
) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterDto>>(emptyList())
    val characters = _characters.asStateFlow()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _characters.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
