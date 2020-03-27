package com.byteme.agricompra.ui.market

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
import com.byteme.agricompra.databinding.MarketFragmentBinding
import com.byteme.agricompra.ui.market.model.Product

class MarketFragment : Fragment() {

    private val viewModel: MarketViewModel by viewModels()
    private lateinit var binding : MarketFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.market_fragment,
            container,
            false
        )

        configureProductList()

        return binding.root
    }

    private fun configureProductList() {
        val adapter = ProductAdapter(
            ProductListener {
                findNavController().navigate(
                    MarketFragmentDirections.actionMarketFragmentToBuyFragment()
                )
            },
            context!!
        )

        val productList = listOf(
            Product("Manzanas", "500", R.drawable.ic_apple),
            Product("Aguacate", "500", R.drawable.ic_avocado),
            Product("Arandanos", "500", R.drawable.ic_blueberry),
            Product("Limón", "500", R.drawable.ic_lemon),
            Product("Naranjas", "500", R.drawable.ic_orange),
            Product("Peras", "500", R.drawable.ic_pear),
            Product("Piñas", "500", R.drawable.ic_pineapple),
            Product("Fresas", "500", R.drawable.ic_strawberry)
        )

        binding.productList.adapter = adapter
        adapter.submitList(productList)
    }

}