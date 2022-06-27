package com.example.animeapi.manager

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapi.model.Anime
import com.example.animeapi.view.AnimeAdapter

class UiHelper {
    companion object {
        fun updateAdapter(view: View, rv: RecyclerView, animes: List<Anime>?) {
            val adapter = AnimeAdapter()

            rv.layoutManager = GridLayoutManager(view.context, 2)
            rv.adapter = adapter

            if (animes != null) {
                adapter.update(animes)
            }
        }
    }
}