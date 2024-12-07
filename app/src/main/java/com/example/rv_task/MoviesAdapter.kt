package com.example.rv_task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_task.databinding.ItemMovieBinding
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var moviesList: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int = moviesList.size

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvMovieName.text = movie.name
            binding.tvMovieDescription.text = movie.description
            binding.tvRating.text = movie.rating.toString()
            binding.tvPublishDate.text = movie.publishDate
            Glide.with(binding.imgMovie.context)
                .load(movie.imageResId) // For local resources
                .placeholder(R.drawable.ic_logo) // Optional: placeholder while loading
                .error(R.drawable.ic_logo) // Optional: image to show if loading fails
                .into(binding.imgMovie)
        }
    }

    fun updateList(newMoviesList: List<Movie>){
        val diffUtilCallback = DiffUtil(oldList = this.moviesList , newList = newMoviesList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallback)
        this.moviesList = newMoviesList
        diffUtilResult.dispatchUpdatesTo(this)

    }

}