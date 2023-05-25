package com.template.tmp02.ui.viewholders

import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.template.tmp02.R
import com.template.tmp02.databinding.ItemHomeShopByNeedsBinding
import com.template.tmp02.databinding.ItemHomeViewpagerBinding
import com.template.tmp02.databinding.ItemMainCategoryRcvBinding
import com.template.tmp02.databinding.ItemMainHomeBestSellerRcvBinding
import com.template.tmp02.databinding.ItemMainHomeCategoryBinding
import com.template.tmp02.ui.adapter.*
import com.template.tmp02.ui.modelclass.HomeMainCategoryData
import com.template.tmp02.ui.modelclass.MainCategoryData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class HomeCategoryViewHolder (binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class HomeBannerCategoryViewHolder(val binding: ItemHomeViewpagerBinding) :
        HomeCategoryViewHolder(binding) {
        fun bind(item: HomeMainCategoryData.HomeBannerCategory) {
            val homebannerViewPager = HomeBannerAdapter()
            binding.vpBanner.apply {
                adapter = homebannerViewPager
                autoScroll(4000)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        val bannerSize = item.homebannerList.size
                        binding.llSlideIndicator.removeAllViews()

                        val slidingImageDotsBanner =
                            List(bannerSize) { ImageView(binding.root.context) }
                        slidingImageDotsBanner.forEach {
                            it.load(R.drawable.inactive_dot_clearbg)
                            binding.llSlideIndicator.addView(it)
                        }
                        slidingImageDotsBanner.getOrNull(0)?.load(R.drawable.active_dot_banner)
                        slidingImageDotsBanner.forEachIndexed { index, imageView ->
                            imageView.load(if (index == position) R.drawable.active_dot_banner else R.drawable.inactive_dot_clearbg)
                        }
                    }
                })
            }
            homebannerViewPager.updateList(item.homebannerList)
        }
        fun ViewPager2.autoScroll(interval: Long) {
            CoroutineScope(Dispatchers.IO).launch {
                scrollIndefinitely(interval)
            }
        }
        private suspend fun ViewPager2.scrollIndefinitely(interval: Long) {
            try {
                while (true) {
                    delay(interval)
                    val numberOfItems = adapter?.itemCount ?: 0
                    if (numberOfItems > 0) {
                        val nextItem = (currentItem + 1) % numberOfItems
                        setCurrentItem(nextItem, true)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    class ShopByNeedsCategoryViewHolder(val binding: ItemHomeShopByNeedsBinding) :
        HomeCategoryViewHolder(binding) {
        fun bind(item: HomeMainCategoryData.HomeShopByNeedCategory) {
            binding.tvTitle.text = item.title
            binding.ivCardiacCare.setImageResource(item.image1)
            binding.ivOralCare.setImageResource(item.image2)
            binding.ivElderlyCare.setImageResource(item.image3)

        }
    }

    class HomeShopByCategoryViewHolder(private val binding: ItemMainHomeCategoryBinding) :
        HomeCategoryViewHolder(binding) {
        fun bind(item: HomeMainCategoryData.HomeShopByCategory) {
            binding.tvTitle.text = item.title
            val a = HomeShopByCategoryAdapter()
            binding.recyclerView.apply {
                adapter = a
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL,false)
            }
            a.updateList(item.homeShopByCategoryList)
        }
    }

    class HomeBrandViewHolder(private val binding: ItemMainHomeCategoryBinding) :
        HomeCategoryViewHolder(binding) {
        fun bind(item: HomeMainCategoryData.HomeBrand) {
            binding.tvTitle.text = item.title
                val a = HomeBrandAdapter()
            binding.recyclerView.apply {
                adapter = a
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL,false)
            }
            a.updateList(item.homeBrandList)
        }
    }

    class HomeBestSellerViewHolder(val binding: ItemMainHomeBestSellerRcvBinding) :
        HomeCategoryViewHolder(binding) {
        fun bind(item: HomeMainCategoryData.HomeBestSeller) {
            binding.tvTitle.text = item.title
            val a = HomeSellerCategoryAdapter()
            binding.recyclerView.apply {
                adapter = a
                layoutManager = GridLayoutManager(binding.root.context, 2)
            }
            a.updateList(item.homeBestSellerList)
        }
    }

}