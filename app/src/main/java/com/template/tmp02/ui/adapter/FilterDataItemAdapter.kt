package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemFilterSetDescriptionBinding
import com.template.tmp02.ui.modelclass.FilterDataItem

class FilterDataItemAdapter (): RecyclerView.Adapter<FilterDataItemAdapter.FilterDataItemViewHolder>() {

    private val filterDataItems = mutableListOf<FilterDataItem>()
    inner class FilterDataItemViewHolder(val binding: ItemFilterSetDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterDataItemViewHolder {
        return FilterDataItemViewHolder(
            ItemFilterSetDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<FilterDataItem>) {
        filterDataItems.clear()
        filterDataItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return filterDataItems.size
    }

    override fun onBindViewHolder(holder: FilterDataItemViewHolder, position: Int) {
        with(filterDataItems[position]) {
            holder.binding.tvTitle.text = title
        }
    }

}