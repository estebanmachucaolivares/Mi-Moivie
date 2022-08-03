package com.example.mimovie.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mimovie.data.database.entities.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies:List<MovieEntity>)

    @Query("SELECT * FROM movies WHERE category=:cat")
    suspend fun getMoviesByCat(cat:String):List<MovieEntity>

}