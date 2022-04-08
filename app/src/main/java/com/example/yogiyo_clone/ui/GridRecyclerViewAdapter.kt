package com.example.yogiyo_clone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yogiyo_clone.R
import com.example.yogiyo_clone.databinding.ActivityItemLayoutBannerBinding

import com.example.yogiyo_clone.databinding.ActivityItemLayoutGridBinding
import com.example.yogiyo_clone.model.GridItem

class GridRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var gridItemList: List<GridItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ActivityItemLayoutGridBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GridItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gridItemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        gridItemList?.let {
            (holder as GridItemViewHolder).bind(it[position])
        }
    }

    //functions
    fun submitList(list: List<GridItem>?) {
        gridItemList = list
        notifyDataSetChanged()
    }


    class GridItemViewHolder(val viewBinding: ActivityItemLayoutGridBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(gridItem: GridItem) {
            viewBinding.ivGridImage.setImageResource(gridItem.image)
            viewBinding.tvGridTitle.text = gridItem.title
        }
    }
}