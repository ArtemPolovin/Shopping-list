package com.example.domain.models.repositories

import com.example.domain.models.ShopItem
import kotlinx.coroutines.flow.Flow

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    //suspend fun getShopList(): Flow<List<ShopItem>>
    fun getShopList(): List<ShopItem>
    fun getShopItemById(shopItemId: Int): ShopItem
}