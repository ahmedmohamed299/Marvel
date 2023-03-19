package com.example.marvel.domain.useCases


import com.example.marvel.data.character.CharacterResponse
import com.example.marvel.domain.repository.CharactersRepository

import javax.inject.Inject

class GetCharacterRemoteUseCase @Inject constructor(private val repository: CharactersRepository) {
     suspend fun execute(offset:String): CharacterResponse =repository.getAllCharacters(offset)


}