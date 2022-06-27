package com.example.android_final.manager

import android.content.Context
import com.example.android_final.model.Anime
import com.example.animeapi.model.db.AnimeDao
import com.example.animeapi.model.db.AppDatabase
import com.example.android_final.network.ApiService

class AnimeManager(context: Context) {
    private var animeDao: AnimeDao? = AppDatabase.createDb(context).animeDao()

    suspend fun downloadPopularAnimes(): List<Anime> {
        val listResponse = ApiService.instance().getListOf20AnimeByPopularity()
        val animes = listResponse.body()?.animeList!!
        saveAnimesToDb(animes)
        return animes
    }

    suspend fun downloadAnimesByName(animeName: String): List<Anime> {
        val listResponse = ApiService.instance().getAnimeByName(animeName)
        val animes = listResponse.body()?.animeList!!
        saveAnimesToDb(animes)
        return animes
    }

    fun getAnimesByName(animeName: String): List<Anime>? {
        return animeDao?.getAnimeLikeTitle(animeName)
    }

    private fun saveAnimesToDb(animes: List<Anime>) {
        for (anime in animes) {
            val animeList = animeDao?.getAnimeLikeTitle(anime.title)
            if (animeList.isNullOrEmpty()) {
                animeDao!!.insert(anime)
            }
        }
    }
}