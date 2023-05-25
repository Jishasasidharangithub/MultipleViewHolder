package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentCartBinding
import com.template.tmp02.databinding.FragmentCategoryListBinding
import com.template.tmp02.ui.adapter.CartItemAdapter
import com.template.tmp02.ui.adapter.HomeMainCategoryAdapter
import com.template.tmp02.ui.modelclass.CartItem

class CartFragment : Fragment() {

    private var binding: FragmentCartBinding?=null
    private val cartItemAdapter: CartItemAdapter by lazy { CartItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCartBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initView()
    }
    private fun init(){
        binding?.includeToolbar?.tvToolbarTitle?.text="CART"
    }

    private fun initView() {
        binding?.rvCart?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cartItemAdapter
            cartListData()
        }

    }
    fun cartListData() {
        val subList = listOf(
            CartItem(
                R.drawable.product1,"SECOND DOUBLE STRENGTH FISH OIL","QYT : 1","AED 90.60"
            ), CartItem(
                R.drawable.product1,"SECOND DOUBLE STRENGTH FISH OIL","QYT : 1","AED 90.60"
            ), CartItem(
                R.drawable.product1,"SECOND DOUBLE STRENGTH FISH OIL","QYT : 1","AED 90.60"
            )
        )
        cartItemAdapter.updateList(subList)}
}