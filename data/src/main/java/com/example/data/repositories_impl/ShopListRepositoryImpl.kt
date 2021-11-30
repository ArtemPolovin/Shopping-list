package com.example.data.repositories_impl

import com.example.domain.models.ShopItem
import com.example.domain.models.repositories.ShopListRepository
import com.example.domain.utils.UNDEFINED_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.flowWith
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({o1,o2 -> o1.id.compareTo(o2.id)})
    private var autoIncrementId = 0

    init {
        for (i in 0 until 30) {
            val shopItem = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(shopItem)
        }
    }


    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItemById(shopItem.id)
        shopList.remove(oldShopItem)
        addShopItem(shopItem)
    }

    /*override suspend fun getShopList(): Flow<List<ShopItem>> {
        return flow{
           emit(shopList)
            println("mLog: finished flow")
        }.flowOn(Dispatchers.Default)
    }*/

    override  fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId was not found")
    }
}