package com.example.marvel.domain.useCases

import com.example.marvel.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharacterSearchRemoteUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend fun execute(search: String) = repository.getAllSearchedCharacters(search)
}