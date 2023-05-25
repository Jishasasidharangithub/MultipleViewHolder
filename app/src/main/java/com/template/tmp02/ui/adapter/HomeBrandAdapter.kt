package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemHomeBrandsBinding
import com.template.tmp02.ui.modelclass.HomeBrandItem

class HomeBrandAdapter () :
    RecyclerView.Adapter<HomeBrandAdapter.HomeBrandItemViewHolder>() {

    private val homeBrandItems = mutableListOf<HomeBrandItem>()

    inner class HomeBrandItemViewHolder(val binding: ItemHomeBrandsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBrandItemViewHolder {
        return HomeBrandItemViewHolder(
            ItemHomeBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: HomeBrandItemViewHolder,
        position: Int
    ) {
        with(homeBrandItems[position]) {
            holder.binding.ivCardiacMedicine.setImageResource(image)
        }    }

    override fun getItemCount(): Int {
        return homeBrandItems.size
    }

    fun updateList(list: List<HomeBrandItem>) {
        homeBrandItems.clear()
        homeBrandItems.addAll(list)
        notifyDataSetChanged()
    }

}