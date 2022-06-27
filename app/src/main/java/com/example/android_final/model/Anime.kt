package com.example.animeapi.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "anime")
data class Anime (

    @ColumnInfo(name = "mal_id")
    var mal_id: String = "0",

    @ColumnInfo(name = "title")
    var title: String = "",

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "synopsis")
    var synopsis: String = "",

    @ColumnInfo(name = "score")
    var score: String = "0",

    @ColumnInfo(name = "image_url")
    var image_url: String = "",

    @Ignore
    @SerializedName("title_japanese") val title_japanese: String = "",

    @Ignore
    @SerializedName("result") val animeList: List<Anime> = listOf()
)