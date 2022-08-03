package com.example.mimovie.domain.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mimovie.R
import com.example.mimovie.databinding.ItemMovieBinding
import com.example.mimovie.domain.model.Movie

class MovieAdapter(private val moviesList:List<Movie>, private val onClickListener:(Movie)->Unit):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie,parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item=moviesList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MovieViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding=ItemMovieBinding.bind(view)
        private val path="https://image.tmdb.org/t/p/w500/"

        fun render(movie:Movie,onClickListener:(Movie)->Unit){

            Glide.with(binding.ivMovie.context).load(path+movie.posterPath).into(binding.ivMovie)
            itemView.setOnClickListener { onClickListener(movie) }
        }
    }
}