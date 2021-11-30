package com.example.shoppinglist.ui.main.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class ShopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val itemName = itemView.findViewById<TextView>(R.id.text_item_name)
    val itemCount = itemView.findViewById<TextView>(R.id.text_item_count)
}