package com.byteme.agricompra.ui.buy.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.byteme.agricompra.R
import com.byteme.agricompra.databinding.PurchaseDialogLayoutBinding
import com.byteme.agricompra.util.configureDialogWindow

class PurchaseDialog : DialogFragment() {

    private val viewModel: PurchaseDialogViewModel by viewModels()
    private lateinit var binding : PurchaseDialogLayoutBinding
    private lateinit var purchaseDialog: Dialog

    companion object {
        fun newInstance(): DialogFragment = PurchaseDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.purchase_dialog_layout,
            container,
            false
        )

        binding.lifecycleOwner = this

        setupObservers()
        setupClickListeners()

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        purchaseDialog = Dialog(context!!)
        with(purchaseDialog) {
            setCanceledOnTouchOutside(false)
            setContentView(R.layout.purchase_dialog_layout)
            configureDialogWindow()
        }
        return purchaseDialog
    }

    private fun setupObservers() {
        viewModel.closeDialog.observe(viewLifecycleOwner, Observer {
            if (it) {
                purchaseDialog.dismiss()
                viewModel.onCloseDialogHandled()
            }
        })
    }

    private fun setupClickListeners() {
        binding.cancelDialog.setOnClickListener {
            viewModel.onCloseDialog()
        }

        binding.confirmButton.setOnClickListener {
            viewModel.onCloseDialog()
        }
    }


}