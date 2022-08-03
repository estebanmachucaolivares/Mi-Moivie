package com.example.mimovie.data.network

import com.example.mimovie.data.model.MovieModel
import com.example.mimovie.data.model.MovieResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieApiClient {
    @GET
    suspend fun getAllPopularMovies(@Url url:String): Response<MovieResultModel>
}