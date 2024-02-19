package com.learn.compose.exoplayer.data

import com.google.gson.annotations.SerializedName

data class MovieModel (
    @SerializedName("result") var result : ArrayList<MovieData>
)


