package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemFilterSetBinding
import com.template.tmp02.ui.modelclass.FilterItem

class FilterItemAdapter(private val listener: FilterItemClickListener): RecyclerView.Adapter<FilterItemAdapter.FilterItemViewHolder>() {

    private val filterItems = mutableListOf<FilterItem>()

    var selectedPosition = 0

    inner class FilterItemViewHolder(val binding: ItemFilterSetBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterItemViewHolder {
        return FilterItemViewHolder(
            ItemFilterSetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<FilterItem>) {
        filterItems.clear()
        filterItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return filterItems.size
    }

    override fun onBindViewHolder(holder: FilterItemViewHolder, position: Int) {
        with(filterItems[position]) {
            holder.binding.tvPrice.text = title
            if (position == selectedPosition) {
                holder.binding.tvPrice.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        com.template.tmp02.R.color.blue
                    )
                )
                holder.binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        com.template.tmp02.R.color.white
                    )
                )
                holder.binding.viewSkinCare.visibility = android.view.View.VISIBLE
            } else {
                holder.binding.tvPrice.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        com.template.tmp02.R.color.black
                    )
                )
                holder.binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        com.template.tmp02.R.color.nav_bg_color
                    )
                )
                holder.binding.viewSkinCare.visibility = android.view.View.GONE
            }
            holder.itemView.setOnClickListener {
                selectedPosition = position
                listener.onItemClick(this)
                notifyDataSetChanged()
            }
        }
    }
interface FilterItemClickListener{
    fun onItemClick(filterItem: FilterItem)
}
}