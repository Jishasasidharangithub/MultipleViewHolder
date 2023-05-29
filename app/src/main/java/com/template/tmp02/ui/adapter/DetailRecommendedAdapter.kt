package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemDetailRecommendedBinding
import com.template.tmp02.ui.modelclass.DetailRecommendedItem


class DetailRecommendedAdapter () :
    RecyclerView.Adapter<DetailRecommendedAdapter.DetailRecommendedItemViewHolder>() {

    private val recommendedItem = mutableListOf<DetailRecommendedItem>()

    inner class DetailRecommendedItemViewHolder(val binding: ItemDetailRecommendedBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailRecommendedItemViewHolder {
        return DetailRecommendedItemViewHolder(
            ItemDetailRecommendedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<DetailRecommendedItem>) {
        recommendedItem.clear()
        recommendedItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return recommendedItem.size
    }

    override fun onBindViewHolder(holder: DetailRecommendedItemViewHolder, position: Int) {
        with(recommendedItem[position]) {
            holder.binding.tvAED.text = aed
            holder.binding.ivCardiacCare.setImageResource(image)
            holder.binding.tvCardiacCareDescription.text = description
        }
    }

}