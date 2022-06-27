package com.example.animeapi.model

import com.google.gson.annotations.SerializedName

data class AnimeList(
    @SerializedName("results") val animeList: List<Anime>
)