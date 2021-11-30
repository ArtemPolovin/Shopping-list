package com.example.domain.models

import com.example.domain.utils.UNDEFINED_ID

data class  ShopItem(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
)
