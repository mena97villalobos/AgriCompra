package com.byteme.agricompra.util

import android.app.ActionBar
import android.app.Dialog
import android.view.Gravity
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.byteme.agricompra.R

@BindingAdapter("setSRC")
fun ImageView.setSRC(resId: Int) {
    this.setImageResource(resId)
}

fun Dialog.configureDialogWindow() =
    with(window!!) {
        setBackgroundDrawableResource(android.R.color.transparent)
        setGravity(Gravity.CENTER)
        attributes.windowAnimations = R.style.DialogAnimation
        setLayout(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )
    }
