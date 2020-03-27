package com.byteme.agricompra.ui.orders.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.OrderDetailFragmentBinding


class OrderDetailFragment : Fragment() {

    private lateinit var binding : OrderDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.order_detail_fragment,
                container,
                false
        )

        // Inflate the layout for this fragment
        return binding.root
    }
}