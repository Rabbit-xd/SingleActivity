package com.example.singleactivity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.singleactivity.adapters.RedditPageAdapter.*
import com.example.singleactivity.databinding.ChildrenDataModalBinding
import com.example.singleactivity.modal.ChildrenDataModal
import com.example.singleactivity.modal.DataModal

class RedditPageAdapter:PagingDataAdapter<ChildrenDataModal, MyViewHolder>(diffCallback ) {

    inner class MyViewHolder(val binding: ChildrenDataModalBinding)
        :RecyclerView.ViewHolder(binding.root)

    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<ChildrenDataModal>(){
            override fun areItemsTheSame(
                oldItem: ChildrenDataModal,
                newItem: ChildrenDataModal
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ChildrenDataModal,
                newItem: ChildrenDataModal
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ChildrenDataModalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
        ))
    }



}