package com.byteme.agricompra.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setSRC")
fun ImageView.setSRC(resId: Int) {
    this.setImageResource(resId)
}
