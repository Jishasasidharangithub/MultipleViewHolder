package com.template.tmp02.ui.viewholders

import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.template.tmp02.R
import com.template.tmp02.databinding.ItemMainCategoryRcvBinding
import com.template.tmp02.databinding.ItemMainViewpagerBinding
import com.template.tmp02.ui.adapter.BannerCategoryAdapter
import com.template.tmp02.ui.adapter.ProductByCategoryAdapter
import com.template.tmp02.ui.adapter.ShopByCategoryAdapter
import com.template.tmp02.ui.modelclass.MainCategoryData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

    class BannerCategoryViewHolder(val binding: ItemMainViewpagerBinding) :
        MainCategoryViewHolders(binding) {
        fun bind(item: MainCategoryData.BannerCategory) {
            val bannerViewPager = BannerCategoryAdapter()
            binding.vpBanner.apply {
                adapter = bannerViewPager
                autoScroll(4000)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        val bannerSize = item.bannerList.size
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
            bannerViewPager.updateList(item.bannerList)
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
}