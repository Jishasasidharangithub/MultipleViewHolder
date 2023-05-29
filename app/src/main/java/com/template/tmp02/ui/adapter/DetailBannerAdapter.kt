package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemDetailBannerBinding
import com.template.tmp02.ui.modelclass.DetailBannerItem

class DetailBannerAdapter  () : RecyclerView.Adapter<DetailBannerAdapter.DetailBannerCategoryViewHolder>() {

    private val detailbannerCategoryItems = mutableListOf<DetailBannerItem>()
    inner class DetailBannerCategoryViewHolder(val binding: ItemDetailBannerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailBannerCategoryViewHolder {
        return DetailBannerCategoryViewHolder(
            ItemDetailBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<DetailBannerItem>){
        detailbannerCategoryItems.clear()
        detailbannerCategoryItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return detailbannerCategoryItems.size
    }

    override fun onBindViewHolder(holder: DetailBannerCategoryViewHolder, position: Int) {
        with(detailbannerCategoryItems[position]) {
            holder.binding.ivProduct.setImageResource(image)
        }    }
}