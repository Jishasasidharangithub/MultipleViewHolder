package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentCartBinding
import com.template.tmp02.ui.adapter.CartItemAdapter
import com.template.tmp02.ui.modelclass.CartItem
import com.template.tmp02.ui.modelclass.SwipeGeusture

class CartFragment : Fragment(), CartItemAdapter.CartItemAdapterListener {

    private var subList = mutableListOf<CartItem>()
    private var binding: FragmentCartBinding? = null
    private val cartItemAdapter: CartItemAdapter by lazy { CartItemAdapter(requireContext(),this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initView()
        swipeToGesture()
    }

    private fun init() {
        binding?.includeToolbar?.tvToolbarTitle?.text = "CART"
    }

    private fun initView() {
        binding?.rvCart?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cartItemAdapter
            binding?.rvCart?.itemAnimator = null
            cartListData()
        }

    }



    private fun swipeToGesture() {
        val swipeGesture = object : SwipeGeusture(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        cartItemAdapter.deleteItem(viewHolder.adapterPosition)
                    }
                }
            }
        }
        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(binding?.rvCart)

    }


    private fun cartListData() {
        subList.addAll(
            listOf(
                CartItem(
                    R.drawable.product1, "SECOND DOUBLE STRENGTH FISH OIL", 1, "AED 90.60"
                ), CartItem(
                    R.drawable.product1, "SECOND DOUBLE STRENGTH FISH OIL", 2, "AED 90.60"
                ), CartItem(
                    R.drawable.product1, "SECOND DOUBLE STRENGTH FISH OIL", 3, "AED 90.60"
                )
            )
        )
        cartItemAdapter.updateList(subList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun viewMoreClick(cartItem: CartItem, pos: Int) {
        TODO("Not yet implemented")
    }

    override fun addItemQuantity(cartItem: CartItem) {
        subList.remove(cartItem)
        subList.add(cartItem.copy(qty = cartItem.qty + 1))
    }

    override fun removeItemQuantity(cartItem: CartItem) {
        subList.remove(cartItem)
        subList.add(cartItem.copy(qty = (cartItem.qty - 1)))
    }
}