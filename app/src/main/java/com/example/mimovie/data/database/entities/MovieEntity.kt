package com.example.mimovie.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mimovie.domain.model.Movie

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name ="id") val id:Long,
    @ColumnInfo(name ="title") val title:String,
    @ColumnInfo(name ="vote_average") val voteAverage:String,
    @ColumnInfo(name ="release_date") val releaseDate:String,
    @ColumnInfo(name ="original_language") val originalLanguage:String,
    @ColumnInfo(name ="overview") val overview:String,
    @ColumnInfo(name ="backdrop_path") val backdropPath:String,
    @ColumnInfo(name ="poster_path") val posterPath:String,
    @ColumnInfo(name ="category") val category:String?="POPULAR"
)


fun Movie.toDomain()=MovieEntity(id,title,voteAverage,releaseDate,originalLanguage,overview,backdropPath,posterPath,category)