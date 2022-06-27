package com.example.animeapi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "user_anime", foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("user_id"),
            onDelete = CASCADE),
        ForeignKey(entity = Anime::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("anime_id"),
            onDelete = CASCADE)]
)
data class
UserAnime (
    @ColumnInfo(name = "user_id")
    val user_id: Int,

    @ColumnInfo(name = "anime_id")
    val anime_id: Int,

    @ColumnInfo(name = "type")
    val type: String,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)