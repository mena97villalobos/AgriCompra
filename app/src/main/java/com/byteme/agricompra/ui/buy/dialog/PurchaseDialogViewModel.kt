package com.byteme.agricompra.ui.buy.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PurchaseDialogViewModel : ViewModel() {

    private val _closeDialog = MutableLiveData(false)
    val closeDialog : LiveData<Boolean>
        get() = _closeDialog


    fun onCloseDialog() {
        _closeDialog.value = true
    }

    fun onCloseDialogHandled() {
        _closeDialog.value = false
    }


}