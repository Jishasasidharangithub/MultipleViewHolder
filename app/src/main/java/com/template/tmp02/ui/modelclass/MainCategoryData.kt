package com.template.tmp02.ui.modelclass

sealed class MainCategoryData {

    class ShopByCategory(
        val id: Int,
        val title: String,
        val categoryList: List<ShopByCategoryItem>
    ) : MainCategoryData()

    class ProductByCategory(
        val id:Int,
        val title: String,
        val productList:List<ProductByCategoryItem>
    ):MainCategoryData()
}