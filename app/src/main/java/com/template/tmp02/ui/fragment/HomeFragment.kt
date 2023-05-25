package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentHomeBinding
import com.template.tmp02.ui.adapter.HomeMainCategoryAdapter
import com.template.tmp02.ui.adapter.MainCategoryAdapter
import com.template.tmp02.ui.modelclass.*

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private val homemainCategoryAdapter: HomeMainCategoryAdapter by lazy { HomeMainCategoryAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding?.rvHomeSet?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = homemainCategoryAdapter
            categoryListData()
        }

    }

    fun categoryListData() {

        val subList = listOf(
            HomeBannerCategoryItem(R.drawable.banner_),
            HomeBannerCategoryItem(R.drawable.banner_),
            HomeBannerCategoryItem(R.drawable.banner_)
        )
        val subList1 = listOf(
            HomeShopByCategoryItem(
                R.drawable.hair_product,
                "HAIR CARE"
            ), HomeShopByCategoryItem(
                R.drawable.personal_care,
                "PERSONAL CARE"
            ), HomeShopByCategoryItem(
                R.drawable.hair_product,
                "HAIR CARE"
            ), HomeShopByCategoryItem(
                R.drawable.personal_care,
                "PERSONAL CARE"
            )
        )
        val subList2 = listOf(
            HomeBrandItem(
                R.drawable.brand1,
            ), HomeBrandItem(
                R.drawable.brand2,
            ), HomeBrandItem(
                R.drawable.brand3,
            ), HomeBrandItem(
                R.drawable.brand1,
            ), HomeBrandItem(
                R.drawable.brand2,
            ), HomeBrandItem(
                R.drawable.brand3,
            )
        )
        val subList3 = listOf(
            HomeBestSellerItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), HomeBestSellerItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), HomeBestSellerItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), HomeBestSellerItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), HomeBestSellerItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), HomeBestSellerItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            )
        )
        val mainList = listOf(
            HomeMainCategoryData.HomeBannerCategory(1, subList),
            HomeMainCategoryData.HomeShopByNeedCategory(2, "SHOP BY NEEDS", R.drawable.cardiac_care,R.drawable.oral_care,R.drawable.elderly_care),
            HomeMainCategoryData.HomeShopByCategory(3, "SHOP BY CATEGORY",subList1),
            HomeMainCategoryData.HomeBrand(4, "BRAND",subList2),
            HomeMainCategoryData.HomeBestSeller(4, "BEST SELLERS",subList3)

        )


        homemainCategoryAdapter.submitList(mainList)
    }

}