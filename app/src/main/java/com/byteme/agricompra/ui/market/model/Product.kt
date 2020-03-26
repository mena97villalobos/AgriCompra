package com.byteme.agricompra.ui.market.model

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val cost: String,
    @DrawableRes val icon: Int
)