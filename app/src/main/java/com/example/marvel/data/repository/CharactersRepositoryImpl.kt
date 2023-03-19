package com.example.marvel.data.repository

import com.example.marvel.data.character.CharacterModel
import com.example.marvel.data.character.CharacterResponse
import com.example.marvel.data.repository.dataSource.CharactersRemoteDataSource
import com.example.marvel.data.utils.Resource
import com.example.marvel.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(private val charactersRemoteDataSource: CharactersRemoteDataSource) :
    CharactersRepository {
    override suspend fun getAllCharacters(offset:String):CharacterResponse {


        return charactersRemoteDataSource.getAllCharacters(offset)

    }

    override suspend fun getAllSearchedCharacters(search: String): Resource<List<CharacterModel>> =
        charactersRemoteDataSource.getAllSearchedCharacters(search = search)
}