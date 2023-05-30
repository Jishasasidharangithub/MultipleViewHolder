package com.template.tmp02.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentCategoryListBinding
import com.template.tmp02.ui.adapter.MainCategoryAdapter
import com.template.tmp02.ui.modelclass.BannerCategoryItem
import com.template.tmp02.ui.modelclass.MainCategoryData
import com.template.tmp02.ui.modelclass.ProductByCategoryItem
import com.template.tmp02.ui.modelclass.ShopByCategoryItem


class CategoryListFragment : Fragment() {

    private val mainCategoryAdapter: MainCategoryAdapter by lazy { MainCategoryAdapter() }
    private var binding: FragmentCategoryListBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCategoryListBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        handleEvents()
    }

    private fun initView(){
        binding?.rvSet?.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = mainCategoryAdapter
            categoryListData()
        }

    }

    private fun handleEvents() {
        binding?.toolbar?.ivBag?.setOnClickListener {
            findNavController().navigate(R.id.filterBottomSheetFragment)
        }
    }

    private fun categoryListData() {

        val subList= listOf(
            BannerCategoryItem(R.drawable.banner_),
            BannerCategoryItem(R.drawable.banner_),
            BannerCategoryItem(R.drawable.banner_)
        )

        val subList2 = listOf(
            ShopByCategoryItem(
                R.drawable.product1,
                "CARDIAC SUPPORT"
            ), ShopByCategoryItem(
                R.drawable.product1,
                "CARDIAC SUPPORT"
            ), ShopByCategoryItem(
                R.drawable.product1,
                "CARDIAC SUPPORT"
            ), ShopByCategoryItem(
                R.drawable.product1,
                "CARDIAC SUPPORT"
            )
        )

        val subList3 = listOf(
            ProductByCategoryItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), ProductByCategoryItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), ProductByCategoryItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), ProductByCategoryItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), ProductByCategoryItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            ), ProductByCategoryItem(
                "AED 250",
                R.drawable.product1,
                "NATURE'S ANSWER HAWTHORN BERRY 1500 MG VEGETARIAN CAPSULES90'S"
            )
        )


        val mainList = listOf(
            MainCategoryData.BannerCategory(1, subList),
            MainCategoryData.ShopByCategory(2,"SHOP BY CATEGORIES", subList2),
            MainCategoryData.ProductByCategory(3,"CARDIAC CARE", subList3),

        )

        mainCategoryAdapter.submitList(mainList)
    }

}