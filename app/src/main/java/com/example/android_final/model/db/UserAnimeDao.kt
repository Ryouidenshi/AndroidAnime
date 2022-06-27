package com.example.animeapi.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.animeapi.model.UserAnime;


@Dao
interface UserAnimeDao {
    @Insert
    fun insert(userAnime: UserAnime)

    @Query("DELETE FROM user_anime")
    fun deleteAll()

    @Query("DELETE FROM user_anime WHERE id= :id")
    fun deleteAnime(id : Int)

    @Query("SELECT * FROM user_anime WHERE type = :label and user_id = :user_id")
    fun getAnimeWithLabelByUser(user_id: Int, label: String): List<UserAnime>

    @Query("SELECT * FROM user_anime WHERE type = :type and user_id = :user_id and anime_id = :anime_id")
    fun getAnimesByUserAnimeAndType(user_id : Int, anime_id: Int, type : String) : List<UserAnime>
}
