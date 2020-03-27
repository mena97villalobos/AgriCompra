package com.byteme.agricompra.ui.buy

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.braintreepayments.cardform.view.CardForm
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.BuyFragmentBinding
import com.byteme.agricompra.ui.buy.dialog.PurchaseDialog

class BuyFragment : Fragment() {

    private val viewModel: BuyViewModel by viewModels()
    private lateinit var binding : BuyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.buy_fragment,
                container,
                false
        )

        setupCardForm()
        setupClickListener()

        return binding.root
    }

    private fun setupClickListener() {
        binding.buyButton.setOnClickListener {
            PurchaseDialog.newInstance().show(parentFragmentManager, "PURCHASE_DIALOG")
        }
    }

    private fun setupCardForm() {
        binding.cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .postalCodeRequired(true)
                .actionLabel("Purchase")
                .setup(activity!! as AppCompatActivity)
    }

}