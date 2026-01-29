package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewMovies)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MovieAdapter(movieList)
        recyclerView.adapter = adapter

        fetchMovies {
            runOnUiThread {
                movieList.clear()
                movieList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun fetchMovies(callback: (List<Movie>) -> Unit) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://192.168.1.21:3000/movies")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { json ->
                    val movies = mutableListOf<Movie>()
                    val array = JSONArray(json)
                    for (i in 0 until array.length()) {
                        val obj = array.getJSONObject(i)
                        movies.add(
                            Movie(
                                id = obj.getInt("id"),
                                title = obj.getString("title"),
                                year = obj.getInt("year"),
                                director = obj.getString("director"),
                                genre = obj.getString("genre"),
                                rating = obj.getDouble("rating")
                            )
                        )
                    }
                    callback(movies)
                }
            }
        })
    }
}
