package com.example.mimovie.data

import com.example.mimovie.data.database.dao.MovieDao
import com.example.mimovie.data.database.entities.MovieEntity
import com.example.mimovie.data.network.MiMovieService
import com.example.mimovie.domain.model.Movie
import com.example.mimovie.domain.model.toDomain
import javax.inject.Inject

class MiMovieRepository @Inject constructor(
    private val api:MiMovieService,
    private val movieDao:MovieDao
) {

    suspend fun getAllMoviesFromApi(cat:String):List<Movie>{
        val res = api.getMovie(cat)
        return res.movies.map{it.toDomain()}
    }

    suspend fun getMoviesFromDatabase(cat:String):List<Movie>{
        val res = movieDao.getMoviesByCat(cat)
        return res.map{it.toDomain()}
    }

    suspend fun insertMovies(movies:List<MovieEntity>){
        movieDao.insertAll(movies)
    }

}