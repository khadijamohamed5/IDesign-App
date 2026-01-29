package com.example.movieapp
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.textTitle)
        val yearText: TextView = itemView.findViewById(R.id.textYear)
        val directorText: TextView = itemView.findViewById(R.id.textDirector)
        val genreText: TextView = itemView.findViewById(R.id.textGenre)
        val ratingText: TextView = itemView.findViewById(R.id.textRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleText.text = "Title: ${movie.title}"
        holder.yearText.text = "Year: ${movie.year}"
        holder.directorText.text = "Director: ${movie.director}"
        holder.genreText.text = "Genre: ${movie.genre}"
        holder.ratingText.text = "Rating: ${movie.rating}"
    }

    override fun getItemCount(): Int = movies.size
}
