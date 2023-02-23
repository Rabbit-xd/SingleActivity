package com.example.singleactivity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.singleactivity.R
import com.example.singleactivity.modal.RedditModal
/**
class RedditsAdapter: PagingDataAdapter<RedditModal, RedditsAdapter.Holder>(RedditsDiffCallback) {
    class Holder (
        val binding: ItemRedditBinding
        ): RecyclerView.ViewHolder(binding.root)



    override fun onBindViewHolder(holder: Holder, position: Int) {
        val reddit = getItem(position)?: return
        with(holder.binding){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditsAdapter.Holder {
        val inflater: LayoutInflater.from(parent.context)
        val binding = ItemRedditBinding.inflate(inflater,parent,false)
        return Holder(binding)
    }
    private fun loadImage(imageView: ImageView, url:String){
        val context = imageView.context
        if (url.isNotBlank()) {
            Glide.with(context)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView)
        }else {
            Glide.with(context)
                .load(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }

}

class RedditsDiffCallback : DiffUtil.ItemCallback<RedditModal>() {
    override fun areItemsTheSame(oldItem: RedditModal, newItem: RedditModal): Boolean {
        return oldItem.kind == newItem.kind
    }

    override fun areContentsTheSame(oldItem: RedditModal, newItem: RedditModal): Boolean {
        return oldItem == newItem
    }

}
**/