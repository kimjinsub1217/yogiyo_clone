package com.example.yogiyo_clone.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yogiyo_clone.R
import com.example.yogiyo_clone.databinding.ActivityItemLayoutBannerBinding
import com.example.yogiyo_clone.model.BannerItem


class ViewPagerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_COUNT = 5
    }

    private var bannerItemList: List<BannerItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ActivityItemLayoutBannerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BannerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bannerItemList?.let { bannerItemList ->
            (holder as BannerViewHolder).bind(bannerItemList[position])
        }
    }

    //functions
    fun submitList(list: List<BannerItem>?) {
        bannerItemList = list
        notifyDataSetChanged()
    }


    //ViewHolder
    class BannerViewHolder
    constructor(val viewBinding:ActivityItemLayoutBannerBinding ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(bannerItem: BannerItem) {
//            itemView.iv_banner_image.setImageResource(bannerItem.image)
            viewBinding.bannerImage.setImageResource(bannerItem.image)
        }
    }
}
