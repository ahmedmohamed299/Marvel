package com.example.marvel.data.repository.dataSourceImpl

import com.example.marvel.data.character.CharacterModel
import com.example.marvel.data.character.CharacterResponse
import com.example.marvel.data.repository.dataSource.CharactersRemoteDataSource
import com.example.marvel.data.service.ApisService
import com.example.marvel.data.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharactersRemoteDataSourceImpl @Inject constructor(private val service: ApisService) :
    CharactersRemoteDataSource {


    override suspend fun getAllCharacters(offset:String) :CharacterResponse{

        return service.getAllCharacters(offset = offset).data!!
    }

    override suspend fun getAllSearchedCharacters(search: String): Resource<List<CharacterModel>> {
        return try {

            val response = service.getAllSearchedCharacters(search = search)
            Resource.Success(response.data?.characterModels!!)

        } catch (e: HttpException) {
            Resource.Error(e.message!!)
        } catch (e: IOException) {
            Resource.Error(e.message!!)

        }


    }
}