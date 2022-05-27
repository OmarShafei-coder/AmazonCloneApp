package com.omarshafei.amazoncloneapp.data.models

import android.graphics.drawable.Drawable

data class Deal(
    val imageResourceId: Drawable,
    val discountPercentage: String,
    val price: Double
)
