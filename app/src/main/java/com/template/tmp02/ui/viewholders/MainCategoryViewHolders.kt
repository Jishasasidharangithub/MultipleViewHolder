package com.template.tmp02.ui.viewholders

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.template.tmp02.databinding.ItemMainCategoryRcvBinding
import com.template.tmp02.ui.adapter.ProductByCategoryAdapter
import com.template.tmp02.ui.adapter.ShopByCategoryAdapter
import com.template.tmp02.ui.modelclass.MainCategoryData
import com.template.tmp02.ui.modelclass.ProductByCategoryItem
import com.template.tmp02.ui.modelclass.ShopByCategoryItem

open class MainCategoryViewHolders(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class ShopByCategoryViewHolder(private val binding: ItemMainCategoryRcvBinding) :
        MainCategoryViewHolders(binding) {
        fun bind(item: MainCategoryData.ShopByCategory) {
            binding.tvTitle.text = item.title
            val a = ShopByCategoryAdapter()
            binding.recyclerView.apply {
                adapter = a
                layoutManager = GridLayoutManager(binding.root.context, 2)
            }
            a.updateList(item.categoryList)
        }
    }

    class ProductByCategoryViewHolder(val binding: ItemMainCategoryRcvBinding) :
        MainCategoryViewHolders(binding) {
        fun bind(item: MainCategoryData.ProductByCategory) {
            binding.tvTitle.text = item.title
            val a = ProductByCategoryAdapter()
            binding.recyclerView.apply {
                adapter = a
                layoutManager = GridLayoutManager(binding.root.context, 2)
            }
            a.updateList(item.productList)
        }
    }
}