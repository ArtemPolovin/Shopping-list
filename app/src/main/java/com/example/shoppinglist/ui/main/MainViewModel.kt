package com.example.shoppinglist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repositories_impl.ShopListRepositoryImpl
import com.example.domain.models.ShopItem
import com.example.domain.usecases.shope_items_list_usecases.DeleteShopItemUseCase
import com.example.domain.usecases.shope_items_list_usecases.EditShopItemUseCase
import com.example.domain.usecases.shope_items_list_usecases.GetShopItemByIdUseCase
import com.example.domain.usecases.shope_items_list_usecases.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShpListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopItemByIdUseCase = GetShopItemByIdUseCase(repository)

    private val _shopList = MutableLiveData<List<ShopItem>>()
    val shopList: LiveData<List<ShopItem>> get() = _shopList

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem> get() = _shopItem

    fun getShopList() {
        _shopList.value = getShpListUseCase.getShopList()
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun getShopItemById(shopItemId: Int) {
        _shopItem.value = getShopItemByIdUseCase.getShopItemById(shopItemId)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
        getShopList()
    }
}