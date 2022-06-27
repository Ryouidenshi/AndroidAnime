package com.example.animeapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.animeapi.databinding.FragmentAnimeDetailBinding
import com.example.android_final.manager.AnimeManager
import com.example.android_final.model.Anime

class AnimeDetailFragment : Fragment() {
    lateinit var anime : Anime
    lateinit var animeManager : AnimeManager
    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        animeManager = AnimeManager(requireContext())
        _binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.animeTitle.text = anime.title
        binding.synopsis.text = anime.synopsis
        Glide
            .with(view)
            .load(anime.image_url)
            .into(binding.animeImage)


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}