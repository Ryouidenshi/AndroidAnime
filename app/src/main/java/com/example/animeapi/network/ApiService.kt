package com.example.animeapi.network;

import com.example.animeapi.model.Anime
import com.example.animeapi.model.AnimeList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/anime")
    suspend fun getAnimeByName(@Query("q") name: String) : Response<AnimeList>

    @GET("search/anime?q=&order_by=score&sort=desc&limit=20")
    suspend fun getListOf20AnimeByPopularity() : Response<AnimeList>


    companion object {
        const val API_URL = "https://api.jikan.moe/v3/"

        fun instance() = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}