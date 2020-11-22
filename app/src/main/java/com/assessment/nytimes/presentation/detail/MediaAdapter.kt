package com.assessment.nytimes.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.nytimes.data.model.MediaMetadata
import com.assessment.nytimes.databinding.ArticleMediaItemBinding

class MediaAdapter(private val mediaList: List<MediaMetadata>?) :
    RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MediaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding =
            ArticleMediaItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        return MediaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.bind(mediaList!![position])
    }

    override fun getItemCount(): Int {
        return mediaList?.size ?: 0
    }

    class MediaViewHolder(private val binding: ArticleMediaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MediaMetadata?) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}