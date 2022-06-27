package com.example.animeapi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "isActive")
    val isActive: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}