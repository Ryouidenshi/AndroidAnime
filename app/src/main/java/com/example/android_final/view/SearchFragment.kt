package com.example.animeapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animeapi.databinding.FragmentSearchBinding
import com.example.android_final.manager.AnimeManager
import com.example.android_final.manager.NetworkManager
import com.example.android_final.manager.UiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    lateinit var animeManager: AnimeManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        animeManager = AnimeManager(requireContext())

        val view = binding.root

        binding.searchButton.setOnClickListener {
            val textField = binding.searchField
            val nm = NetworkManager(view.context)
            val connected = nm.isConnectedToInternet

            GlobalScope.launch(Dispatchers.IO) {
                val animeName = textField.text.toString()
                val animes = if (connected!!) {
                    animeManager.downloadAnimesByName(animeName)
                } else {
                    animeManager.getAnimesByName(animeName)
                }
                withContext(Dispatchers.Main) {
                    UiHelper.updateAdapter(view, binding.recView, animes)
                }
            }
        }

        return view
    }
}