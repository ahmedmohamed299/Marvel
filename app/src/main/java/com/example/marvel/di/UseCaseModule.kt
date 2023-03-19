package com.example.marvel.di

import com.example.marvel.domain.repository.CharactersRepository
import com.example.marvel.domain.useCases.GetCharacterRemoteUseCase
import com.example.marvel.domain.useCases.GetCharacterSearchRemoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetAllCoachesUseCase(charactersRepository: CharactersRepository): GetCharacterRemoteUseCase =
        GetCharacterRemoteUseCase(charactersRepository)

    @Provides
    fun provideGetCharacterSearchRemoteUseCase(charactersRepository: CharactersRepository): GetCharacterSearchRemoteUseCase =
        GetCharacterSearchRemoteUseCase(charactersRepository)

}