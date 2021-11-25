package com.example.domain.usecases.shope_items_list_usecases

import com.example.domain.models.ShopItem
import com.example.domain.models.repositories.ShopListRepository

class GetShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemById(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemById(shopItemId)
    }
}