package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemBenefitsBinding
import com.template.tmp02.databinding.ItemHomeBrandsBinding
import com.template.tmp02.ui.modelclass.BenefitsItem
import com.template.tmp02.ui.modelclass.HomeBrandItem

class BenefitsAdapter() :
    RecyclerView.Adapter<BenefitsAdapter.BenefitsItemViewHolder>() {

    private val benefitsItems = mutableListOf<BenefitsItem>()

    inner class BenefitsItemViewHolder(val binding: ItemBenefitsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsItemViewHolder {
        return BenefitsItemViewHolder(
            ItemBenefitsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return benefitsItems.size
    }

    override fun onBindViewHolder(holder: BenefitsItemViewHolder, position: Int) {
        with(benefitsItems[position]) {
            holder.binding.tvPoints.text = description
        }
    }

    fun updateList(list: List<BenefitsItem>) {
        benefitsItems.clear()
        benefitsItems.addAll(list)
        notifyDataSetChanged()
    }


}