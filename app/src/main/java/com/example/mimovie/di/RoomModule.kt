package com.example.mimovie.di

import android.content.Context
import androidx.room.Room
import com.example.mimovie.data.database.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val MOVIES_DATABASE_NAME="mi_movies_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context,MovieDataBase::class.java, MOVIES_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providerMovieDao(db:MovieDataBase)=db.getMovieDao()

}