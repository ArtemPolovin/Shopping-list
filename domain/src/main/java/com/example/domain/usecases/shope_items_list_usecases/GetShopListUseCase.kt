package com.example.domain.usecases.shope_items_list_usecases

import com.example.domain.models.ShopItem
import com.example.domain.models.repositories.ShopListRepository
import kotlinx.coroutines.flow.Flow

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}