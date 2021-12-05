package com.example.shoppinglist.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.ui.main.recyclerview.ShopListAdapter
import com.example.shoppinglist.ui.shop_item.ShopItemActivity
import com.example.shoppinglist.utils.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var mAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val buttonAddItem = findViewById<FloatingActionButton>(R.id.button_add_shop_item)
        buttonAddItem.setOnClickListener {
            val intent = ShopItemActivity.newIntentAddItem(this)
            startActivity(intent)
        }

        setupRecyclerView()
        getShopList()
    }

    private fun getShopList() {
        viewModel.shopList.observe(this) {
            mAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_items)
        mAdapter = ShopListAdapter()
        rvShopList.adapter = mAdapter
        rvShopList.recycledViewPool.setMaxRecycledViews(
            ENABLED_SHOP_ITEM,
            MAX_POOL_SIZE_SHOP_LIST_ADAPTER
        )
        rvShopList.recycledViewPool.setMaxRecycledViews(
            DISABLED_SHOP_ITEM,
            MAX_POOL_SIZE_SHOP_LIST_ADAPTER
        )

        setupLongClickListener()
        setupClickListener()
        setupSwipeListener(rvShopList)
    }

    private fun setupSwipeListener(recyclerView: RecyclerView) {
        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val shopItem = mAdapter.currentList[viewHolder.adapterPosition]
                    viewModel.deleteShopItem(shopItem)

                }
            }
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }

    private fun setupLongClickListener() {
        mAdapter.onOnLongShopItemClickListener = {
            viewModel.changeEnabledState(it)
        }
    }

    private fun setupClickListener() {
        mAdapter.onShopItemClickListener = {
            val intent = ShopItemActivity.newIntentEditItem(this, it.id)
            startActivity(intent)
        }
    }

    override fun onResume() {
        viewModel.getShopList()
        super.onResume()
    }


}