package com.example.mimovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mimovie.data.database.dao.MovieDao
import com.example.mimovie.data.database.entities.MovieEntity


@Database(entities = [MovieEntity::class],version = 1)
abstract class MovieDataBase:RoomDatabase() {

    abstract fun getMovieDao():MovieDao
}