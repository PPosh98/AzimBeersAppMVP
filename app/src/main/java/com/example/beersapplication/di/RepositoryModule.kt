package com.example.beersapplication.di

import com.example.beersapplication.api.FetchAPI
import com.example.beersapplication.repository.RemoteDataSource
import com.example.beersapplication.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun getRepository(retrofit: Retrofit): FetchAPI = retrofit.create(FetchAPI::class.java)

//    @Provides
//    fun provideRemoteRepositorySource(api: FetchAPI): RemoteDataSource = RemoteDataSource(api)
//
//    @Provides
//    fun provideBeersRepositoryRef(remoteDataSource: RemoteDataSource) : Repository = Repository(remoteDataSource)
}