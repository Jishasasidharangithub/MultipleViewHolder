package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
 import com.template.tmp02.databinding.ItemProductByCategoryRcvBinding
import com.template.tmp02.ui.modelclass.ProductByCategoryItem

class ProductByCategoryAdapter() :
    RecyclerView.Adapter<ProductByCategoryAdapter.SubCardiacCareViewHolder>() {

    private val products = mutableListOf<ProductByCategoryItem>()

    inner class SubCardiacCareViewHolder(val binding: ItemProductByCategoryRcvBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCardiacCareViewHolder {
        return SubCardiacCareViewHolder(
            ItemProductByCategoryRcvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<ProductByCategoryItem>) {
        products.clear()
        products.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: SubCardiacCareViewHolder, position: Int) {
        with(products[position]) {
            holder.binding.tvAED.text = aed
            holder.binding.ivCardiacCare.setImageResource(image)
            holder.binding.tvCardiacCareDescription.text = description
        }
    }
}