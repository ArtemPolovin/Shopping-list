package com.example.domain.usecases.shope_items_list_usecases

import com.example.domain.models.ShopItem
import com.example.domain.models.repositories.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}