package com.example.foodlist

import androidx.annotation.DrawableRes

data class Food(
    val name:String,
    @DrawableRes val imageUrl: Int
)
