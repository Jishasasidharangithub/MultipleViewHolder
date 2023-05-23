package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.template.tmp02.databinding.ItemMainCategoryRcvBinding
import com.template.tmp02.ui.modelclass.MainCategoryData
import com.template.tmp02.ui.viewholders.MainCategoryViewHolders

class MainCategoryAdapter : ListAdapter<MainCategoryData, MainCategoryViewHolders>(DiffUtilCallback()) {

    companion object {
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainCategoryData.ShopByCategory -> VIEW_ONE
            is MainCategoryData.ProductByCategory -> VIEW_TWO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolders {
        return when (viewType) {
            VIEW_ONE -> {
                MainCategoryViewHolders.ShopByCategoryViewHolder(
                    ItemMainCategoryRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_TWO -> {
                MainCategoryViewHolders.ProductByCategoryViewHolder(
                    ItemMainCategoryRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw java.lang.Exception("Unknown ViewType Found!  in MainCategoryAdapter.kt")
        }
    }

    override fun onBindViewHolder(holder: MainCategoryViewHolders, position: Int) {
        val data = getItem(position)
        when(holder){
            is MainCategoryViewHolders.ShopByCategoryViewHolder -> holder.bind(data as MainCategoryData.ShopByCategory)
            is MainCategoryViewHolders.ProductByCategoryViewHolder -> holder.bind(data as MainCategoryData.ProductByCategory)
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<MainCategoryData>() {
        override fun areItemsTheSame(
            oldItem: MainCategoryData,
            newItem: MainCategoryData
        ): Boolean {
            return when {
                oldItem is MainCategoryData.ShopByCategory && newItem is MainCategoryData.ShopByCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is MainCategoryData.ProductByCategory && newItem is MainCategoryData.ProductByCategory -> {
                    oldItem.id == newItem.id
                }
                else -> false
            }
        }

        override fun areContentsTheSame(
            oldItem: MainCategoryData,
            newItem: MainCategoryData
        ): Boolean {
            return when {
                oldItem is MainCategoryData.ShopByCategory && newItem is MainCategoryData.ShopByCategory -> {
                    oldItem == newItem
                }
                oldItem is MainCategoryData.ProductByCategory && newItem is MainCategoryData.ProductByCategory -> {
                    oldItem == newItem
                }
                else -> false
            }
        }
    }
}