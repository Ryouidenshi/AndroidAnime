package com.example.animeapi

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.animeapi.model.Anime
import com.example.animeapi.model.db.AnimeDao
import com.example.animeapi.model.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DatabaseUnitTest {
    private lateinit var animeDao: AnimeDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext;
        animeDao = AppDatabase.createDb(context).animeDao()
    }

    @Test
    fun insert_anime_isCorrect() {
        val anime = Anime("18507", "Free!", 0, "Haruka Nanase has a love for water and a passion for swimming. In elementary school, he competed in and won a relay race with his three friends Rin Matsuoka, Nagisa Hazuki, and Makoto Tachibana. After...",
                            "7.36", "https:\\/\\/cdn.myanimelist.net\\/images\\/anime\\/6\\/51107.jpg?s=277f33627dad8f3f349c2ac234138ca6")
        GlobalScope.launch(Dispatchers.IO) {
            animeDao.insert(anime)
            val added_anime = animeDao.getAnimeByMalId("18507")
            animeDao.deleteAnimeById(added_anime.id)
            assertEquals(anime.title, added_anime.title)
        }
    }
}