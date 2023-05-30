package com.template.tmp02.ui.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.R
import com.template.tmp02.databinding.ItemNavdrawerBinding
import com.template.tmp02.ui.modelclass.CategoriesNavItem

class CategoryNavAdapter(private val listener: CategoryNavAdapterListener) :
    RecyclerView.Adapter<CategoryNavAdapter.CategoryNavViewHolder>() {

    private val categoryNavItems = mutableListOf<CategoriesNavItem>()

    var selectedPosition = 0

    inner class CategoryNavViewHolder(val binding: ItemNavdrawerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNavViewHolder {
        return CategoryNavViewHolder(
            ItemNavdrawerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<CategoriesNavItem>) {
        categoryNavItems.clear()
        categoryNavItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return categoryNavItems.size
    }

    override fun onBindViewHolder(holder: CategoryNavViewHolder, position: Int) {
        with(categoryNavItems[position]) {
            holder.binding.tvSkinCare.text = title
            if (position == selectedPosition) {
                holder.binding.tvSkinCare.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.white
                    )
                )
                holder.binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.blue
                    )
                )
                holder.binding.viewSkinCare.visibility = View.VISIBLE
            } else {
                holder.binding.tvSkinCare.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.black
                    )
                )
                holder.binding.root.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.white
                    )
                )
                holder.binding.viewSkinCare.visibility = View.GONE
            }
            holder.itemView.setOnClickListener {
                selectedPosition = position
                notifyDataSetChanged()
            }
        }
    }

    interface CategoryNavAdapterListener {
        fun viewMoreClick(categoryNavItem: CategoriesNavItem, pos: Int) {

        }
    }

}