package com.example.mimovie.domain.usecases

import android.util.Log
import com.example.mimovie.data.MiMovieRepository
import com.example.mimovie.data.database.entities.toDomain
import com.example.mimovie.domain.model.Movie
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(private val repository: MiMovieRepository){
    suspend operator fun invoke():List<Movie>{
        val category="top_rated"
        var movies=repository.getMoviesFromDatabase(category)

        return if(movies.isNullOrEmpty()){

            movies=repository.getAllMoviesFromApi(category)

            var newMovies:MutableList<Movie> = movies.toMutableList()

            for(movie in newMovies){
                movie.category=category
            }

            repository.insertMovies(newMovies.map {
                it.toDomain()
            })

            movies
        }else{
            movies
        }
    }
}