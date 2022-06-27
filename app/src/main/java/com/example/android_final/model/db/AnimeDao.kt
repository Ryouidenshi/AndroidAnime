package com.example.animeapi.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_final.model.Anime


@Dao
interface AnimeDao {
    @Insert
    fun insert(anime: Anime)

    @Query("SELECT * FROM anime")
    fun getAnimes() : List<Anime>

    @Query("SELECT * FROM anime WHERE mal_id = :malId")
    fun getAnimeByMalId(malId : String) : Anime

    @Query("SELECT * FROM anime WHERE id = :id")
    fun getAnimeById(id : Int) : Anime

    @Query("DELETE FROM anime")
    fun deleteAll()

    @Query("DELETE FROM anime WHERE id = :id")
    fun deleteAnimeById(id : Int)

    @Query("SELECT * FROM anime WHERE title LIKE '%' || :title || '%'")
    fun getAnimeLikeTitle(title : String) : List<Anime>

    @Query("SELECT * FROM anime ORDER BY score desc")
    fun getAnimeSortedByScore() : List<Anime>
}
