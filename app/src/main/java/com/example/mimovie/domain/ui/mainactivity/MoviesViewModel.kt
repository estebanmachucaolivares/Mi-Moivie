package com.example.mimovie.domain.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mimovie.domain.model.Movie
import com.example.mimovie.domain.usecases.GeUpcomingMoviesUsecase
import com.example.mimovie.domain.usecases.GetPopularMoviesUseCase
import com.example.mimovie.domain.usecases.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUsecase: GeUpcomingMoviesUsecase

    ):ViewModel() {

    private var allPopularMovieP=MutableLiveData<List<Movie>>()
    val allPopularMovie: LiveData<List<Movie>> = allPopularMovieP

    private var isLoadingPopularMovieP=MutableLiveData<Boolean>();
    val isLoadingPopularMovie:LiveData<Boolean> = isLoadingPopularMovieP


    private var allTopRatedMovieP=MutableLiveData<List<Movie>>()
    val allTopRatedMovie: LiveData<List<Movie>> = allTopRatedMovieP

    private var isLoadingTopRatedMovieP=MutableLiveData<Boolean>();
    val isLoadingTopRatedMovie:LiveData<Boolean> = isLoadingTopRatedMovieP


    private var allUpComingMovieP=MutableLiveData<List<Movie>>()
    val allUpComingMovie: LiveData<List<Movie>> = allUpComingMovieP

    private var isLoadingUpComingMovieP=MutableLiveData<Boolean>();
    val isLoadingUpComingMovie:LiveData<Boolean> = isLoadingUpComingMovieP

    private var movieP=MutableLiveData<Movie>()
    private var movie:LiveData<Movie> = movieP


    fun onCreate(){
        viewModelScope.launch {
            isLoadingPopularMovieP.postValue(true)
            val movies= getPopularMoviesUseCase()
            allPopularMovieP.postValue(movies)

            isLoadingPopularMovieP.postValue(false)
        }

        viewModelScope.launch {
            isLoadingTopRatedMovieP.postValue(true)
            val movies= getTopRatedMoviesUseCase()
            allTopRatedMovieP.postValue(movies)

            isLoadingTopRatedMovieP.postValue(false)
        }

        viewModelScope.launch {
            isLoadingUpComingMovieP.postValue(true)
            val movies= getUpcomingMoviesUsecase()
            allUpComingMovieP.postValue(movies)
            isLoadingUpComingMovieP.postValue(false)
        }
    }

    fun sendPopularMovie(movie:Movie){
        movieP.postValue(movie)
    }
}