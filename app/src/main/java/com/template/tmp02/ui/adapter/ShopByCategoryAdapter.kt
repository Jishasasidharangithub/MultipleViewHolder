package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemShowByCategoryRcvBinding
import com.template.tmp02.ui.modelclass.ShopByCategoryItem

class ShopByCategoryAdapter () : RecyclerView.Adapter<ShopByCategoryAdapter.SubShowByCategoryViewHolder>() {

    private val shopByCategoryItems = mutableListOf<ShopByCategoryItem>()
    inner class SubShowByCategoryViewHolder(val binding: ItemShowByCategoryRcvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubShowByCategoryViewHolder {
        return SubShowByCategoryViewHolder(
            ItemShowByCategoryRcvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return shopByCategoryItems.size
    }

    fun updateList(list: List<ShopByCategoryItem>){
        shopByCategoryItems.clear()
        shopByCategoryItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SubShowByCategoryViewHolder, position: Int) {
        with(shopByCategoryItems[position]) {
            holder.binding.ivCardiacMedicine.setImageResource(image)
            holder.binding.tvCardiacMedicineName.text = title
        }
    }

}