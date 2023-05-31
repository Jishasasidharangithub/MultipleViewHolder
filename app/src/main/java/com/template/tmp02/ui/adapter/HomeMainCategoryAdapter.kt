package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.template.tmp02.databinding.*
import com.template.tmp02.ui.modelclass.HomeMainCategoryData
import com.template.tmp02.ui.viewholders.HomeCategoryListener
import com.template.tmp02.ui.viewholders.HomeCategoryViewHolder

class HomeMainCategoryAdapter(private var listener: HomeCategoryListener) :
    ListAdapter<HomeMainCategoryData, HomeCategoryViewHolder>(DiffUtilCallback()) {

    companion object {
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
        const val VIEW_THREE = 3
        const val VIEW_FOUR = 4
        const val VIEW_FIVE = 5
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeMainCategoryData.HomeBannerCategory -> VIEW_ONE
            is HomeMainCategoryData.HomeShopByNeedCategory -> VIEW_TWO
            is HomeMainCategoryData.HomeShopByCategory -> VIEW_THREE
            is HomeMainCategoryData.HomeBrand -> VIEW_FOUR
            is HomeMainCategoryData.HomeBestSeller -> VIEW_FIVE
            else -> throw java.lang.Exception("Unknown Get item position!!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        return when (viewType) {
            HomeMainCategoryAdapter.VIEW_ONE -> {
                HomeCategoryViewHolder.HomeBannerCategoryViewHolder(
                    ItemHomeViewpagerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HomeMainCategoryAdapter.VIEW_TWO -> {
                HomeCategoryViewHolder.ShopByNeedsCategoryViewHolder(
                    ItemHomeShopByNeedsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HomeMainCategoryAdapter.VIEW_THREE -> {
                HomeCategoryViewHolder.HomeShopByCategoryViewHolder(
                    ItemMainHomeCategoryBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HomeMainCategoryAdapter.VIEW_FOUR -> {
                HomeCategoryViewHolder.HomeBrandViewHolder(
                    ItemMainHomeCategoryBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HomeMainCategoryAdapter.VIEW_FIVE -> {
                HomeCategoryViewHolder.HomeBestSellerViewHolder(
                    ItemMainHomeBestSellerRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw java.lang.Exception("Unknown ViewType Found!  in MainCategoryAdapter.kt")
        }
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        val data = getItem(position)
        holder.homeCategoryVHListener = listener
        when (holder) {
            is HomeCategoryViewHolder.HomeBannerCategoryViewHolder -> holder.bind(data as HomeMainCategoryData.HomeBannerCategory)
            is HomeCategoryViewHolder.ShopByNeedsCategoryViewHolder -> holder.bind(data as HomeMainCategoryData.HomeShopByNeedCategory)
            is HomeCategoryViewHolder.HomeShopByCategoryViewHolder -> holder.bind(data as HomeMainCategoryData.HomeShopByCategory)
            is HomeCategoryViewHolder.HomeBrandViewHolder -> holder.bind(data as HomeMainCategoryData.HomeBrand)
            is HomeCategoryViewHolder.HomeBestSellerViewHolder -> holder.bind(data as HomeMainCategoryData.HomeBestSeller)
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<HomeMainCategoryData>() {
        override fun areItemsTheSame(
            oldItem: HomeMainCategoryData,
            newItem: HomeMainCategoryData
        ): Boolean {
            return when {
                oldItem is HomeMainCategoryData.HomeBannerCategory && newItem is HomeMainCategoryData.HomeBannerCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is HomeMainCategoryData.HomeShopByNeedCategory && newItem is HomeMainCategoryData.HomeShopByNeedCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is HomeMainCategoryData.HomeShopByCategory && newItem is HomeMainCategoryData.HomeShopByCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is HomeMainCategoryData.HomeBrand && newItem is HomeMainCategoryData.HomeBrand -> {
                    oldItem.id == newItem.id
                }
                oldItem is HomeMainCategoryData.HomeBestSeller && newItem is HomeMainCategoryData.HomeBestSeller -> {
                    oldItem.id == newItem.id
                }
                else -> false
            }
        }

        override fun areContentsTheSame(
            oldItem: HomeMainCategoryData,
            newItem: HomeMainCategoryData
        ): Boolean {
            return when {
                oldItem is HomeMainCategoryData.HomeBannerCategory && newItem is HomeMainCategoryData.HomeBannerCategory -> {
                    oldItem == newItem
                }
                oldItem is HomeMainCategoryData.HomeShopByNeedCategory && newItem is HomeMainCategoryData.HomeShopByNeedCategory -> {
                    oldItem == newItem
                }
                oldItem is HomeMainCategoryData.HomeShopByCategory && newItem is HomeMainCategoryData.HomeShopByCategory -> {
                    oldItem == newItem
                }
                oldItem is HomeMainCategoryData.HomeBrand && newItem is HomeMainCategoryData.HomeBrand -> {
                    oldItem == newItem
                }
                oldItem is HomeMainCategoryData.HomeBestSeller && newItem is HomeMainCategoryData.HomeBestSeller -> {
                    oldItem == newItem
                }
                else -> false
            }
        }


    }
}