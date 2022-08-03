package com.example.mimovie.domain.model

import com.example.mimovie.data.database.entities.MovieEntity
import com.example.mimovie.data.model.MovieModel
import com.google.gson.annotations.SerializedName

data class Movie(
    val id:Long,
    val title:String,
    val voteAverage:String,
    val releaseDate:String,
    val originalLanguage:String,
    val overview:String,
    val backdropPath:String,
    val posterPath:String,
    var category:String?="POPULAR"
)

fun MovieModel.toDomain()=Movie(id,title,voteAverage,releaseDate,originalLanguage,overview,backdropPath,posterPath,category)
fun MovieEntity.toDomain()=Movie(id,title,voteAverage,releaseDate,originalLanguage,overview,backdropPath,posterPath,category)
