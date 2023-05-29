package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.template.tmp02.databinding.*
import com.template.tmp02.ui.modelclass.DetailMainCategoryData
import com.template.tmp02.ui.viewholders.DetailCategoryViewHolder
import com.template.tmp02.ui.viewholders.HomeCategoryViewHolder

class DetailMainAdapter : ListAdapter<DetailMainCategoryData, DetailCategoryViewHolder>(
    DetailMainAdapter.DiffUtilCallback()
) {
    class DiffUtilCallback : DiffUtil.ItemCallback<DetailMainCategoryData>() {
        override fun areItemsTheSame(
            oldItem: DetailMainCategoryData,
            newItem: DetailMainCategoryData
        ): Boolean {
            return when {
                oldItem is DetailMainCategoryData.DetailBannerCategory && newItem is DetailMainCategoryData.DetailBannerCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is DetailMainCategoryData.DetailDescriptionCategory && newItem is DetailMainCategoryData.DetailDescriptionCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is DetailMainCategoryData.DetailRecommendedCategory && newItem is DetailMainCategoryData.DetailRecommendedCategory -> {
                    oldItem.id == newItem.id
                }
                else -> false
            }
        }

        override fun areContentsTheSame(
            oldItem: DetailMainCategoryData,
            newItem: DetailMainCategoryData
        ): Boolean {
            return when {
                oldItem is DetailMainCategoryData.DetailBannerCategory && newItem is DetailMainCategoryData.DetailBannerCategory -> {
                    oldItem == newItem
                }
                oldItem is DetailMainCategoryData.DetailDescriptionCategory && newItem is DetailMainCategoryData.DetailDescriptionCategory -> {
                    oldItem == newItem
                }
                oldItem is DetailMainCategoryData.DetailRecommendedCategory && newItem is DetailMainCategoryData.DetailRecommendedCategory -> {
                    oldItem == newItem
                }
                else -> false
            }
        }


    }

    companion object {
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
        const val VIEW_THREE = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DetailMainCategoryData.DetailBannerCategory -> DetailMainAdapter.VIEW_ONE
            is DetailMainCategoryData.DetailDescriptionCategory -> DetailMainAdapter.VIEW_TWO
            is DetailMainCategoryData.DetailRecommendedCategory -> DetailMainAdapter.VIEW_THREE
            else -> throw java.lang.Exception("Unknown Get item position!!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCategoryViewHolder {
        return when (viewType) {
            DetailMainAdapter.VIEW_ONE -> {
                DetailCategoryViewHolder.DetailBannerCategoryViewHolder(
                    ItemDetailViewpagerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            DetailMainAdapter.VIEW_TWO -> {
                DetailCategoryViewHolder.DetalDescriptionCategoryViewHolder(
                    ItemDetailDescriptionBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            DetailMainAdapter.VIEW_THREE -> {
                DetailCategoryViewHolder.DetailRecommendedCategoryViewHolder(
                    ItemDetailRecommendedRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }else -> throw java.lang.Exception("Unknown ViewType Found!  in MainCategoryAdapter.kt")
        }
    }

    override fun onBindViewHolder(holder: DetailCategoryViewHolder, position: Int) {
        val data = getItem(position)
        when (holder) {
            is DetailCategoryViewHolder.DetailBannerCategoryViewHolder -> holder.bind(data as DetailMainCategoryData.DetailBannerCategory)
            is DetailCategoryViewHolder.DetalDescriptionCategoryViewHolder -> holder.bind(data as DetailMainCategoryData.DetailDescriptionCategory)
            is DetailCategoryViewHolder.DetailRecommendedCategoryViewHolder -> holder.bind(data as DetailMainCategoryData.DetailRecommendedCategory)

        }
    }
}