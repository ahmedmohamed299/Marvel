package com.example.marvel.di

import com.example.marvel.data.repository.dataSource.CharactersRemoteDataSource
import com.example.marvel.data.repository.CharactersRepositoryImpl
import com.example.marvel.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCoachRepo(coachesRemoteDataSource: CharactersRemoteDataSource): CharactersRepository =
        CharactersRepositoryImpl(coachesRemoteDataSource)

}