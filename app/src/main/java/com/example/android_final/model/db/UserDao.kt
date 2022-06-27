package com.example.animeapi.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_final.model.User


@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user")
    fun getUsers() : List<User>

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("DELETE FROM user WHERE login = :login")
    fun deleteUserByLogin(login : String)

    @Query("SELECT * FROM user WHERE login = :login")
    fun getUserByLogin(login : String) : List<User>

    @Query("UPDATE user SET isActive = 1 WHERE id = :userId")
    fun setActive(userId : Int)

    @Query("UPDATE user SET isActive = 0")
    fun deactivateAll()

    @Query("SELECT * FROM user WHERE isActive = 1")
    fun getActiveUser() : User
}
