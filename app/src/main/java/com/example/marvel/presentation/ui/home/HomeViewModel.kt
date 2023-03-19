package com.example.marvel.presentation.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.marvel.data.character.CharacterModel
import com.example.marvel.data.character.CharacterResponse
import com.example.marvel.data.utils.Resource
import com.example.marvel.domain.useCases.GetCharacterRemoteUseCase
import com.example.marvel.domain.useCases.GetCharacterSearchRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchRemoteUseCase: GetCharacterSearchRemoteUseCase,
    private val getCharacterRemoteUseCase: GetCharacterRemoteUseCase
) :
    ViewModel() {
    private var searchMutableLiveData = MutableLiveData<Resource<List<CharacterModel>>>()

    val searchLiveData: LiveData<Resource<List<CharacterModel>>>
        get() = searchMutableLiveData
    private var characterMutableLiveData = MutableLiveData<Resource<CharacterResponse>>()

    val characterLiveData: LiveData<Resource<CharacterResponse>>
        get() = characterMutableLiveData


    fun getCharacters(offset: String) {
        characterMutableLiveData.postValue(Resource.Loading())
        try {


            viewModelScope.launch(Dispatchers.IO) {
                characterMutableLiveData.postValue(
                    Resource.Success(
                        getCharacterRemoteUseCase.execute(
                            offset
                        )
                    )
                )
            }

        } catch (e: Exception) {
            characterMutableLiveData.postValue(Resource.Error(e.message!!))
        }
    }

    fun getSearchCharacters(search: String) {
        searchMutableLiveData.postValue(Resource.Loading())
        try {
            viewModelScope.launch(Dispatchers.IO) {

                val response = searchRemoteUseCase.execute(search)
                Log.d("ahmed", "getSearchCharacters: ${response.data} ")
                searchMutableLiveData.postValue(response)
            }
        } catch (e: Exception) {
            searchMutableLiveData.postValue(Resource.Error(e.message!!))
        }
    }


}