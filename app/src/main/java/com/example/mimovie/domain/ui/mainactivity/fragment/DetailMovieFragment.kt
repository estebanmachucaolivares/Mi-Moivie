package com.example.mimovie.domain.ui.mainactivity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mimovie.R
import com.example.mimovie.databinding.FragmentDetailMovieBinding
import com.example.mimovie.domain.ui.mainactivity.MoviesViewModel

class DetailMovieFragment : Fragment() {

    private var _binding:FragmentDetailMovieBinding? = null

    private val binding get() = _binding!!

    private val moviesViewModel: MoviesViewModel by activityViewModels()

    private val path="https://image.tmdb.org/t/p/w500/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentDetailMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesViewModel.movie.observe(viewLifecycleOwner, Observer {

            it?.let {
                binding.tvTitle.text = it.title
                binding.tvOverview.text = it.overview
                binding.tvOriginalLanguage.text="Idioma ${it.originalLanguage}"
                binding.tvReleaseDate.text=it.releaseDate
                binding.tvVoteAverageCount.text="${it.voteAverage} (${it.voteCount} Reseñas)"

                Glide.with(requireContext())
                    .applyDefaultRequestOptions(
                        RequestOptions()
                        .placeholder(R.drawable.default_poster)
                        .error(R.drawable.default_poster))
                    .load(path+it.posterPath)
                    .into(binding.ivMoviePoster)

                Glide.with(requireContext())
                    .applyDefaultRequestOptions(
                        RequestOptions()
                            .placeholder(R.drawable.default_background)
                            .error(R.drawable.default_background))
                    .load(path+it.backdropPath)
                    .into(binding.ivMovieBackground)
            }
        })
        
        binding.cvGuardar.setOnClickListener { Toast.makeText(requireContext(), getString(R.string.guardar), Toast.LENGTH_SHORT).show() }
        binding.cvCompartir.setOnClickListener { Toast.makeText(requireContext(), getString(R.string.compartir), Toast.LENGTH_SHORT).show() }
        binding.cvFavorito.setOnClickListener { Toast.makeText(requireContext(), getString(R.string.favorito), Toast.LENGTH_SHORT).show() }
    }

}