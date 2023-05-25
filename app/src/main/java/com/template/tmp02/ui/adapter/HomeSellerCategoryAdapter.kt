package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemHomeBestSellersBinding
import com.template.tmp02.ui.modelclass.HomeBestSellerItem

class HomeSellerCategoryAdapter () :
    RecyclerView.Adapter<HomeSellerCategoryAdapter.HomeSellerItemViewHolder>() {

    private val bestSellerProduct = mutableListOf<HomeBestSellerItem>()

    inner class HomeSellerItemViewHolder(val binding: ItemHomeBestSellersBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSellerItemViewHolder {
        return HomeSellerItemViewHolder(
            ItemHomeBestSellersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<HomeBestSellerItem>) {
        bestSellerProduct.clear()
        bestSellerProduct.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return bestSellerProduct.size
    }

    override fun onBindViewHolder(holder: HomeSellerItemViewHolder, position: Int) {
        with(bestSellerProduct[position]) {
            holder.binding.tvAED.text = aed
            holder.binding.ivCardiacCare.setImageResource(image)
            holder.binding.tvCardiacCareDescription.text = description
        }
    }
}