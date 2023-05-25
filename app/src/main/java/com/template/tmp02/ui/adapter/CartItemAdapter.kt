package com.template.tmp02.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemCartBinding
import com.template.tmp02.ui.modelclass.CartItem

class CartItemAdapter  () : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    private val cartItem = mutableListOf<CartItem>()
    inner class CartItemViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder(
            ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<CartItem>){
        cartItem.clear()
        cartItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        with(cartItem[position]) {
            holder.binding.ivCart.setImageResource(image)
            holder.binding.tvCartTitle.text = title
            holder.binding.tvCartQTY.text = qyt
            holder.binding.tvCartAED.text = aed
        }
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }

}