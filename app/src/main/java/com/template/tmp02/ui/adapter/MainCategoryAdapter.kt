package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.template.tmp02.databinding.ItemMainCategoryRcvBinding
import com.template.tmp02.databinding.ItemMainViewpagerBinding
import com.template.tmp02.ui.modelclass.MainCategoryData
import com.template.tmp02.ui.viewholders.MainCategoryListener
import com.template.tmp02.ui.viewholders.MainCategoryViewHolders

class MainCategoryAdapter(private var listener: MainCategoryListener ) :
    ListAdapter<MainCategoryData, MainCategoryViewHolders>(DiffUtilCallback()) {

    companion object {
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
        const val VIEW_THREE = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainCategoryData.BannerCategory -> VIEW_ONE
            is MainCategoryData.ShopByCategory -> VIEW_TWO
            is MainCategoryData.ProductByCategory -> VIEW_THREE
            else -> throw java.lang.Exception("Unknown Get item position!!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolders {
        return when (viewType) {
            VIEW_TWO -> {
                MainCategoryViewHolders.ShopByCategoryViewHolder(
                    ItemMainCategoryRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_THREE -> {
                MainCategoryViewHolders.ProductByCategoryViewHolder(
                    ItemMainCategoryRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_ONE -> {
                MainCategoryViewHolders.BannerCategoryViewHolder(
                    ItemMainViewpagerBinding.inflate(
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
        holder.mainCategoryVHListener = listener
        val data = getItem(position)
        when (holder) {
            is MainCategoryViewHolders.BannerCategoryViewHolder -> holder.bind(data as MainCategoryData.BannerCategory)
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
                oldItem is MainCategoryData.BannerCategory && newItem is MainCategoryData.BannerCategory -> {
                    oldItem.id == newItem.id
                }
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
                oldItem is MainCategoryData.BannerCategory && newItem is MainCategoryData.BannerCategory -> {
                    oldItem == newItem
                }
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