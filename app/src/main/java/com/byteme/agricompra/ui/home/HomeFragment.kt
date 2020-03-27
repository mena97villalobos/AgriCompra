package com.byteme.agricompra.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.HomeFragmentBinding
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private val itemAdapter by lazy {
        ItemAdapter { position: Int, _: Item ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToBuyFragment())
            item_list.smoothScrollToPosition(position)
        }
    }

    private val possibleItems = listOf(
        Item("Manzanas", R.drawable.ic_apple),
        Item("Aguacate", R.drawable.ic_avocado),
        Item("Arandanos", R.drawable.ic_blueberry),
        Item("Limón", R.drawable.ic_lemon),
        Item("Naranjas", R.drawable.ic_orange),
        Item("Peras", R.drawable.ic_pear),
        Item("Piñas", R.drawable.ic_pineapple),
        Item("Fresas", R.drawable.ic_strawberry)
    )

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding : HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )

        binding.itemList.initialize(itemAdapter)
        binding.itemList.setViewsToChangeColor(listOf(R.id.list_item_background, R.id.list_item_text))
        itemAdapter.setItems(getLargeListOfItems())

        setupClickListeners()

        return binding.root
    }

    private fun setupClickListeners() {
        binding.logout.setOnClickListener {
            AuthUI.getInstance().signOut(requireContext()).addOnSuccessListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
            }
        }

        binding.orders.setOnClickListener(Navigation.createNavigateOnClickListener(
            HomeFragmentDirections.actionHomeFragmentToOrdersFragment()
        ))

        binding.market.setOnClickListener(Navigation.createNavigateOnClickListener(
            HomeFragmentDirections.actionHomeFragmentToMarketFragment()
        ))
    }

    private fun getLargeListOfItems(): List<Item> {
        val items = mutableListOf<Item>()
        (0..40).map { items.add(possibleItems.random()) }
        return items
    }

}