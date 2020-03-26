package com.byteme.agricompra.ui.market

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.ProductCardLayoutBinding
import com.byteme.agricompra.ui.market.model.Product


class ProductAdapter(
    private val clickListener: ProductListener,
    private val context: Context
) :
    ListAdapter<Product, ProductAdapter.ViewHolder>(ReceiptDiffCallback()) {


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
    class ViewHolder private constructor(private val binding: ProductCardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Creates view from parent inflater
         */
        companion object {

            fun from(parent: ViewGroup): ViewHolder =
                ViewHolder(
                    ProductCardLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }


        /**
         * Binds objects to view
         */
        fun bind(item: Product, clickListener: ProductListener) {
            binding.product = item
            binding.executePendingBindings()
        }
    }

}


/**
 * Creates class to updateReceipt RecyclerView
 */
class ReceiptDiffCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem.title == newItem.title &&  oldItem.cost == newItem.cost


    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem
}


/**
 * Creates click listener for each item of the Recycler View
 */
class ProductListener(val clickListener: (product: Product) -> Unit) {

    fun onClick(product: Product) = clickListener(product)

}
