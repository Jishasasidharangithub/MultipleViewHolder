package com.template.tmp02.ui.modelclass

sealed class DetailMainCategoryData {

    class DetailBannerCategory(
        val id:Int,
        val detailbannerList: List<DetailBannerItem>
    ): DetailMainCategoryData()

    class DetailDescriptionCategory(
        val id:Int,
        val title:String,
        val detail:String,
        val aed:String,
        val description:String,
        val benefitsList: List<BenefitsItem>,
        val useDescription:String
    ): DetailMainCategoryData()

    class DetailRecommendedCategory(
        val id:Int,
        val title:String,
        val detalRecommendedList: List<DetailRecommendedItem>
    ): DetailMainCategoryData()

}