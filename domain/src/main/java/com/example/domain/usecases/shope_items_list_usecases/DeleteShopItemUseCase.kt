package com.example.domain.usecases.shope_items_list_usecases

import com.example.domain.models.ShopItem
import com.example.domain.models.repositories.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}