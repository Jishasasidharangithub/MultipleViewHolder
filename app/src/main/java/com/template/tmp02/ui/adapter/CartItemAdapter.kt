package com.template.tmp02.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.tmp02.databinding.ItemCartBinding
import com.template.tmp02.ui.modelclass.CartItem

class CartItemAdapter  (private val context: Context, private val listener: CartItemAdapterListener) : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

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
            holder.binding.tvCartQTY.text = "$qty"
            holder.binding.tvCartNumber.text = "$qty"
            holder.binding.tvCartAED.text = aed

            holder.binding.ivIncrement.setOnClickListener {
                qty += 1
                holder.binding.tvCartNumber.text = "$qty"
                holder.binding.tvCartQTY.text = "QTY :$qty"
                listener.addItemQuantity(this)
             }
            holder.binding.ivDecrement.setOnClickListener {
                if (qty>1){
                    qty -= 1
                    holder.binding.tvCartNumber.text = "$qty"
                    holder.binding.tvCartQTY.text = "QTY : $qty"
                    listener.removeItemQuantity(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }
    fun deleteItem(adapterPosition : Int){
        cartItem.removeAt(adapterPosition)
        notifyDataSetChanged()
    }

    interface CartItemAdapterListener {
        fun viewMoreClick(cartItem: CartItem, pos: Int)
        fun addItemQuantity(cartItem: CartItem)
        fun removeItemQuantity(cartItem: CartItem)
    }

}