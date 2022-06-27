package com.example.animeapi.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.animeapi.R
import com.example.animeapi.manager.NetworkManager
import com.example.animeapi.model.Anime
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var animeSelected : Anime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nm = NetworkManager(this.applicationContext)
        if (!nm.isConnectedToInternet!!) {
            toolbar.setTitle(toolbar.title.toString() + " - OFFLINE")
        }
        setSupportActionBar(toolbar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setItemIconTintList(null);

    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun switchContent(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        var rootView = this.findViewById<View>(android.R.id.content)
        ft.replace(rootView.id, fragment, fragment.toString())
        ft.addToBackStack(fragment.toString())
        ft.commit()

        (fragment as AnimeDetailFragment).anime = animeSelected
    }
}