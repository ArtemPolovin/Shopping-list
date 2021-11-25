package com.example.domain.usecases.shope_items_list_usecases

import com.example.domain.models.ShopItem
import com.example.domain.models.repositories.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
       shopListRepository.addShopItem(shopItem)
    }
}