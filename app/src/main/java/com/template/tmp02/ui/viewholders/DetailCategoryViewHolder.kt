package com.template.tmp02.ui.viewholders

import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.template.tmp02.R
import com.template.tmp02.databinding.ItemDetailDescriptionBinding
import com.template.tmp02.databinding.ItemDetailRecommendedRcvBinding
import com.template.tmp02.databinding.ItemDetailViewpagerBinding
import com.template.tmp02.databinding.ItemHomeShopByNeedsBinding
import com.template.tmp02.databinding.ItemMainHomeBestSellerRcvBinding
import com.template.tmp02.ui.adapter.*
import com.template.tmp02.ui.modelclass.DetailMainCategoryData
import com.template.tmp02.ui.modelclass.HomeMainCategoryData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait

open class DetailCategoryViewHolder (binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class DetailBannerCategoryViewHolder(val binding: ItemDetailViewpagerBinding) :
        DetailCategoryViewHolder(binding) {
        fun bind(item: DetailMainCategoryData.DetailBannerCategory) {
            val detailbannerViewPager = DetailBannerAdapter()
            binding.vpBanner.apply {
                adapter = detailbannerViewPager
                autoScroll(4000)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        val bannerSize = item.detailbannerList.size
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
            detailbannerViewPager.updateList(item.detailbannerList)
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

    class DetalDescriptionCategoryViewHolder(val binding: ItemDetailDescriptionBinding) :
        DetailCategoryViewHolder(binding) {
        fun bind(item: DetailMainCategoryData.DetailDescriptionCategory) {
            binding.tvDetailTitle.text = item.title
            binding.tvProductDetail.text = item.detail
            binding.tvAED.text = item.aed
            binding.tvDescription.text = item.description
            binding.tvHowToUseDescription.text = item.useDescription

            val a = BenefitsAdapter()
            binding.rvBenefits.apply {
                adapter = a
                layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL,false)
            }
            a.updateList(item.benefitsList)
        }
    }

    class DetailRecommendedCategoryViewHolder(val binding: ItemDetailRecommendedRcvBinding) :
        DetailCategoryViewHolder(binding) {
        fun bind(item: DetailMainCategoryData.DetailRecommendedCategory) {
            binding.tvTitle.text = item.title
            val a = DetailRecommendedAdapter()
            binding.recyclerView.apply {
                adapter = a
                layoutManager = GridLayoutManager(binding.root.context, 2)
            }
            a.updateList(item.detalRecommendedList)
        }
    }

}