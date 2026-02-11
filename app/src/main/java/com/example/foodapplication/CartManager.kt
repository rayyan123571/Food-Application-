package com.example.foodapplication

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object CartManager {
    private const val PREFS_NAME = "cart_prefs"
    private const val KEY_CART_ITEMS = "cart_items"
    
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()
    private val cartItems = mutableListOf<Food>()

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        loadCart()
    }

    private fun loadCart() {
        val json = sharedPreferences.getString(KEY_CART_ITEMS, null)
        if (json != null) {
            val type = object : TypeToken<List<Food>>() {}.type
            val saved: List<Food> = gson.fromJson(json, type) ?: emptyList()
            cartItems.clear()
            cartItems.addAll(saved)
        }
    }

    private fun saveCart() {
        val json = gson.toJson(cartItems)
        sharedPreferences.edit().putString(KEY_CART_ITEMS, json).apply()
    }

    fun addToCart(item: Food) {
        val existing = cartItems.find { it.name == item.name }
        if (existing != null) {
            existing.quantity += item.quantity
        } else {
            cartItems.add(item)
        }
        saveCart()
    }

    /** Subtracts one unit; removes if quantity ≤ 1 */
    fun decrementFromCart(item: Food) {
        val existing = cartItems.find { it.name == item.name } ?: return
        if (existing.quantity > 1) {
            existing.quantity -= 1
        } else {
            cartItems.remove(existing)
        }
        saveCart()
    }

    /** Removes the entire item regardless of quantity */
    fun removeFromCart(item: Food) {
        cartItems.removeIf { it.name == item.name }
        saveCart()
    }

    fun clearCart() {
        cartItems.clear()
        saveCart()
    }

    fun getCartItems(): List<Food> = cartItems.toList()

    fun getTotalItems(): Int = cartItems.sumOf { it.quantity }

    fun getSubtotal(): Int = cartItems.sumOf { it.getPriceInt() * it.quantity }

    fun getDiscount(): Int = (getSubtotal() * 0.04).toInt()

    fun getTotalAmount(): Int = getSubtotal() - getDiscount()
}
