package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentDetailBinding
import com.template.tmp02.databinding.FragmentHomeBinding
import com.template.tmp02.ui.adapter.DetailMainAdapter
import com.template.tmp02.ui.adapter.HomeMainCategoryAdapter
import com.template.tmp02.ui.modelclass.*

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val detailmainCategoryAdapter: DetailMainAdapter by lazy { DetailMainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding?.rvDetailSet?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = detailmainCategoryAdapter
            categoryListData()
        }

    }

    fun categoryListData() {

        val subList = listOf(
            DetailBannerItem(R.drawable.banner_),
            DetailBannerItem(R.drawable.banner_),
            DetailBannerItem(R.drawable.banner_)
        )

        val subList1 = listOf(
            BenefitsItem(
                "Supports and maintain healthy heart"
            ), BenefitsItem(
                "No fishy after tasty"
            ), BenefitsItem(
                "Tested for heavy metals"
            )
        )
        val subList2 = listOf(
            DetailRecommendedItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), DetailRecommendedItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), DetailRecommendedItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), DetailRecommendedItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), DetailRecommendedItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), DetailRecommendedItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            )
        )

        val mainList = listOf(
            DetailMainCategoryData.DetailBannerCategory(1, subList),
            DetailMainCategoryData.DetailDescriptionCategory(2,"SECOND DOUBLE STRENGTH FISH OIL","1200 CAPSULES 60'S","AED 60.50","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tortor lectus, maximus a dolor non, semper vestibulum mauris. Proin ut ex diam.",subList1,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tortor lectus, maximus a dolor non, semper vestibulum mauris. Proin ut ex diam."),
            DetailMainCategoryData.DetailRecommendedCategory(3, "YOU MAY ALSO LIKE",subList2)
        )


        detailmainCategoryAdapter.submitList(mainList)
    }
}