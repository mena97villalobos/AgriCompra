package com.byteme.agricompra.ui.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.OrderCardLayoutBinding
import com.byteme.agricompra.ui.orders.model.Order

class OrderAdapter (
    private val clickListener: OrderListener,
    private val context: Context
) :
    ListAdapter<Order, OrderAdapter.ViewHolder>(OrderDiffCallback()) {


    /**
     * Creates each element (receipt) to display on the Receipt Fragment
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)


    /**
     * Binds each element
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_scale)
        holder.bind(getItem(position)!!, clickListener)
    }


    /**
     * Creates class for each element to be rendered
     */
    class ViewHolder private constructor(private val binding: OrderCardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Creates view from parent inflater
         */
        companion object {

            fun from(parent: ViewGroup): ViewHolder =
                ViewHolder(
                    OrderCardLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }

        /**
         * Binds objects to view
         */
        fun bind(order: Order, clickListener: OrderListener) {
            binding.clickListener = clickListener
            binding.orderName.text = order.title
            binding.executePendingBindings()
        }
    }

}


/**
 * Creates class to updateReceipt RecyclerView
 */
class OrderDiffCallback : DiffUtil.ItemCallback<Order>() {

    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean =
        oldItem.title == newItem.title


    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean =
        oldItem == newItem
}


/**
 * Creates click listener for each item of the Recycler View
 */
class OrderListener(val clickListener: () -> Unit) {

    fun onClick() = clickListener()

}