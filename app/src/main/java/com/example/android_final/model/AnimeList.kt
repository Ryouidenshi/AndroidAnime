package com.example.android_final.model

import com.example.android_final.model.Anime
import com.google.gson.annotations.SerializedName

data class AnimeList(
    @SerializedName("results") val animeList: List<Anime>
)