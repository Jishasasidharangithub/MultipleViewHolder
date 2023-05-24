package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemViewpagerBannerBinding
import com.template.tmp02.ui.modelclass.BannerCategoryItem


class BannerCategoryAdapter () : RecyclerView.Adapter<BannerCategoryAdapter.BannerCategoryViewHolder>() {

    private val bannerCategoryItems = mutableListOf<BannerCategoryItem>()
    inner class BannerCategoryViewHolder(val binding: ItemViewpagerBannerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerCategoryViewHolder {
        return BannerCategoryViewHolder(
            ItemViewpagerBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return bannerCategoryItems.size
    }

    fun updateList(list: List<BannerCategoryItem>){
        bannerCategoryItems.clear()
        bannerCategoryItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BannerCategoryViewHolder, position: Int) {
        with(bannerCategoryItems[position]) {
            holder.binding.ivProduct.setImageResource(image)
        }
    }

}