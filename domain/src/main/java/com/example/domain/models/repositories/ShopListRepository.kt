package com.example.domain.models.repositories

import com.example.domain.models.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopList(): List<ShopItem>
    fun getShopItemById(shopItemId: Int): ShopItem
}