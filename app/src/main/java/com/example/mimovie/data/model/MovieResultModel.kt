package com.example.mimovie.data.model

import com.google.gson.annotations.SerializedName

data class MovieResultModel(@SerializedName("results") val movies:List<MovieModel>)
