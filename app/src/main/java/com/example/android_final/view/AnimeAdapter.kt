package com.example.android_final.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animeapi.databinding.AnimeItemBinding
import com.example.android_final.manager.AnimeManager
import com.example.android_final.model.Anime
import com.example.animeapi.view.AnimeDetailFragment
import com.example.animeapi.view.MainActivity


class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeTitleHolder>() {
    lateinit var itemBinding: AnimeItemBinding
    lateinit var animeManager : AnimeManager

    var list = listOf<Anime>()
    lateinit var mContext : Context

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<Anime>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeTitleHolder {
        itemBinding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        animeManager = AnimeManager(parent.context)
        mContext = parent.context

        return AnimeTitleHolder(itemBinding)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: AnimeTitleHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            fragmentJump(item)
        }

    }

    private fun fragmentJump(selectedAnime: Anime) {
        val newFragment = AnimeDetailFragment()

        if (mContext is MainActivity) {
            val mainActivity = mContext as MainActivity
            mainActivity.animeSelected = selectedAnime
            mainActivity.switchContent(newFragment)
        }
    }

    class AnimeTitleHolder(private val itemBinding: AnimeItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Anime) {
            val image_view = itemBinding.imageView

            Glide
                .with(itemBinding.root)
                .load(item.image_url)
                .into(image_view)

            itemBinding.title.text = item.title
        }
    }
}