package com.example.mimovie.data.network

import android.util.Log
import com.example.mimovie.data.model.MovieModel
import com.example.mimovie.data.model.MovieResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MiMovieService @Inject constructor(private val api:MovieApiClient) {
    private val apiKey="24b8abbb4dbdbc8551ccb52dbf7914ff"
    suspend fun getMovie(category:String):MovieResultModel {
        return withContext(Dispatchers.IO){
            val response:Response<MovieResultModel> = api.getAllPopularMovies("3/movie/$category/?api_key=$apiKey&language=es")
            //Log.e("RES_CARS", response.body().toString())
            (response.body() ?: null)!!
        }
    }
}