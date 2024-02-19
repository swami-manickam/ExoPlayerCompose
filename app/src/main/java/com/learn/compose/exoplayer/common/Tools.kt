package com.learn.compose.exoplayer.common

import android.content.Context
import com.google.gson.Gson
import com.learn.compose.exoplayer.data.MovieData
import com.learn.compose.exoplayer.data.MovieModel

object Tools {
    private val gsonConvertor by lazy { Gson() }



    fun parseJsonFromAssets(context: Context, fileName: String): List<MovieData>{

        // Read the JSON file from assets
        val jsonString = try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList()
        }

        // Use Gson to convert the JSON string into a list of movies
        return try {
            val moviesResponse = Gson().fromJson(jsonString, MovieModel::class.java)
            moviesResponse.result
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}