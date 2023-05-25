package com.template.tmp02.ui.modelclass

sealed class HomeMainCategoryData {

    class HomeBannerCategory(
        val id:Int,
        val homebannerList: List<HomeBannerCategoryItem>
    ): HomeMainCategoryData()

    class HomeShopByNeedCategory(
        val id:Int,
        val title:String,
        val image1:Int,
        val image2:Int,
        val image3:Int,
    ): HomeMainCategoryData()

    class HomeShopByCategory(
        val id:Int,
        val title:String,
        val homeShopByCategoryList: List<HomeShopByCategoryItem>
    ): HomeMainCategoryData()

    class HomeBrand(
        val id:Int,
        val title:String,
        val homeBrandList: List<HomeBrandItem>
    ): HomeMainCategoryData()

    class HomeBestSeller(
        val id:Int,
        val title:String,
        val homeBestSellerList: List<HomeBestSellerItem>
    ): HomeMainCategoryData()
}