package com.example.animeapi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animeapi.databinding.FragmentPopularBinding
import com.example.android_final.manager.AnimeManager
import com.example.android_final.manager.UiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeFragment : Fragment() {
    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!
    lateinit var animeManager: AnimeManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        animeManager = AnimeManager(requireContext())

        val view = binding.root

        GlobalScope.launch(Dispatchers.IO) {
            val animes = animeManager.downloadPopularAnimes();
            animeManager.downloadPopularAnimes();
            withContext(Dispatchers.Main) {
                UiHelper.updateAdapter(view, binding.recView, animes)
            }
        }
        return view
    }
}