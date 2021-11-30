package com.example.shoppinglist.ui.main.recyclerview


import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.models.ShopItem
import com.example.shoppinglist.R
import com.example.shoppinglist.utils.DISABLED_SHOP_ITEM
import com.example.shoppinglist.utils.ENABLED_SHOP_ITEM

class ShopListAdapter : ListAdapter<ShopItem, ShopListViewHolder>(ShopItemDiffCallback()) {

  //  private val shopList = mutableListOf<ShopItem>()

    var onOnLongShopItemClickListener : ((ShopItem) -> Unit)? = null
    var onShopItemClickListener : ((ShopItem) -> Unit)? = null

    /*fun setupShopList(newList: List<ShopItem>) {
        shopList.clear()
        shopList.addAll(newList)
        notifyDataSetChanged()
    }*/

   // fun getItemByPosition(itemPosition: Int) = shopList[itemPosition]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val layout = if (viewType == ENABLED_SHOP_ITEM) {
            R.layout.cell_shop_item_enabled
        } else {
            R.layout.cell_shop_item_disabled
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = getItem(position)

        holder.itemName.text = shopItem.name
        holder.itemCount.text= shopItem.count.toString()

        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }

        holder.itemView.setOnLongClickListener {
            onOnLongShopItemClickListener?.invoke(shopItem)
            true
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).enabled) ENABLED_SHOP_ITEM
        else DISABLED_SHOP_ITEM
    }


}