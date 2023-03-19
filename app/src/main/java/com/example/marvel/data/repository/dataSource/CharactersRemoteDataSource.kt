package com.example.marvel.data.repository.dataSource

import com.example.marvel.data.character.CharacterModel
import com.example.marvel.data.character.CharacterResponse
import com.example.marvel.data.utils.Resource

interface CharactersRemoteDataSource {
    suspend fun getAllCharacters(offset:String): CharacterResponse
    suspend fun getAllSearchedCharacters(search: String): Resource<List<CharacterModel>>

}