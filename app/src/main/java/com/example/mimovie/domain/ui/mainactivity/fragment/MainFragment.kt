package com.example.mimovie.domain.ui.mainactivity.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimovie.R
import com.example.mimovie.databinding.FragmentMainBinding
import com.example.mimovie.domain.model.Movie
import com.example.mimovie.domain.ui.mainactivity.MoviesViewModel
import com.example.mimovie.domain.ui.adapter.MovieAdapter


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesViewModel.onCreate();

        moviesViewModel.isLoadingPopularMovie.observe(viewLifecycleOwner) {
            Log.e("TAG", "isLoadingPopularMovie $it")
        }

        moviesViewModel.isLoadingTopRatedMovie.observe(viewLifecycleOwner) {
            Log.e("TAG", "isLoadingTopRatedMovie $it")
        }

        moviesViewModel.isLoadingUpComingMovie.observe(viewLifecycleOwner) {
            Log.e("TAG", "isLoadingUpComingMovie $it")
        }

        binding.rvMoviesPopular.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMoviesTopRated.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMoviesUpcoming.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)


        moviesViewModel.allPopularMovie.observe(viewLifecycleOwner)  {
            binding.rvMoviesPopular.adapter = MovieAdapter(it) { movie -> onItemSelected(movie) }
        }

        moviesViewModel.allTopRatedMovie.observe(viewLifecycleOwner)  {
            binding.rvMoviesTopRated.adapter = MovieAdapter(it) { movie -> onItemSelected(movie) }
        }

        moviesViewModel.allUpComingMovie.observe(viewLifecycleOwner)  {
            binding.rvMoviesUpcoming.adapter = MovieAdapter(it) { movie -> onItemSelected(movie) }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onItemSelected(movie: Movie){
        moviesViewModel.sendPopularMovie(movie)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

}