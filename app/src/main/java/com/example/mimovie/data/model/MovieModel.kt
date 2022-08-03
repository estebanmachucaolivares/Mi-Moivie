package com.example.mimovie.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id") val id:Long,
    @SerializedName("title") val title:String,
    @SerializedName("vote_average") val voteAverage:String,
    @SerializedName("release_date") val releaseDate:String,
    @SerializedName("original_language") val originalLanguage:String,
    @SerializedName("overview") val overview:String,
    @SerializedName("backdrop_path") val backdropPath:String,
    @SerializedName("poster_path") val posterPath:String,
    @SerializedName("category") val category:String?="POPULAR",
    @SerializedName("vote_count") val voteCount:String
)
