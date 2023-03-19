package com.example.marvel.di

import com.example.marvel.data.repository.dataSource.CharactersRemoteDataSource
import com.example.marvel.data.repository.dataSourceImpl.CharactersRemoteDataSourceImpl
import com.example.marvel.data.service.ApisService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideCharactersRemoteDataSource(service: ApisService): CharactersRemoteDataSource =
        CharactersRemoteDataSourceImpl(service)


}