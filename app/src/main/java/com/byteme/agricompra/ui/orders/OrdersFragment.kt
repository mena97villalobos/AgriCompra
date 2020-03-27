package com.byteme.agricompra.ui.orders

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.OrdersFragmentBinding
import com.byteme.agricompra.ui.orders.model.Order

class OrdersFragment : Fragment() {

    private val viewModel: OrdersViewModel by viewModels()
    private lateinit var binding : OrdersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.orders_fragment,
            container,
            false
        )

        setupOrdersList()

        return binding.root
    }

    private fun setupOrdersList() {
        val adapter = OrderAdapter(
            OrderListener {
                findNavController().navigate(
                    OrdersFragmentDirections.actionOrdersFragmentToOrderDetailFragment()
                )
            },
            context!!
        )

        val ordersList = listOf(
            Order("Orden #0"),
            Order("Orden #1"),
            Order("Orden #2"),
            Order("Orden #3"),
            Order("Orden #4"),
            Order("Orden #5"),
            Order("Orden #6"),
            Order("Orden #7"),
            Order("Orden #8"),
            Order("Orden #9")
        )

        binding.ordersList.adapter = adapter
        adapter.submitList(ordersList)
    }

}