package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository
) : ViewModel(){

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.delete(item)
    }

    fun getAllShoppingItems() = shoppingRepository.getAllShoppingItems()

}