package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemHomeBannerBinding
import com.template.tmp02.ui.modelclass.HomeBannerCategoryItem

class HomeBannerAdapter () : RecyclerView.Adapter<HomeBannerAdapter.HomeBannerCategoryViewHolder>() {

    private val homebannerCategoryItems = mutableListOf<HomeBannerCategoryItem>()
    inner class HomeBannerCategoryViewHolder(val binding: ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeBannerCategoryViewHolder {
        return HomeBannerCategoryViewHolder(
            ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<HomeBannerCategoryItem>){
        homebannerCategoryItems.clear()
        homebannerCategoryItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return homebannerCategoryItems.size
    }

    override fun onBindViewHolder(holder: HomeBannerCategoryViewHolder, position: Int) {
        with(homebannerCategoryItems[position]) {
            holder.binding.ivProduct.setImageResource(image)
        }    }
}