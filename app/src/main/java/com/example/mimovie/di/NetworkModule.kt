package com.example.mimovie.di

import com.example.mimovie.core.RetrofitHelper
import com.example.mimovie.data.network.MovieApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create(RetrofitHelper.gson))
            .build()
    }

    @Singleton
    @Provides
    fun providerMoviesApiClient(retrofit:Retrofit):MovieApiClient{
        return retrofit.create(MovieApiClient::class.java)
    }

}