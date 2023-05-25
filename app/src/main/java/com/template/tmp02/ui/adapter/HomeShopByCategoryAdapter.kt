package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemHomeShopByCategoryBinding
import com.template.tmp02.ui.modelclass.HomeShopByCategoryItem

class HomeShopByCategoryAdapter() :
    RecyclerView.Adapter<HomeShopByCategoryAdapter.HomeShopByCategoryViewHolder>() {

    private val homeShopByCategoryItems = mutableListOf<HomeShopByCategoryItem>()

    inner class HomeShopByCategoryViewHolder(val binding: ItemHomeShopByCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeShopByCategoryViewHolder {
        return HomeShopByCategoryViewHolder(
            ItemHomeShopByCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: HomeShopByCategoryViewHolder,
        position: Int
    ) {
        with(homeShopByCategoryItems[position]) {
            holder.binding.ivCardiacMedicine.setImageResource(image)
            holder.binding.tvCardiacMedicineName.text = title
        }    }

    override fun getItemCount(): Int {
        return homeShopByCategoryItems.size
    }

    fun updateList(list: List<HomeShopByCategoryItem>) {
        homeShopByCategoryItems.clear()
        homeShopByCategoryItems.addAll(list)
        notifyDataSetChanged()
    }

}