package com.example.foodapplication

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object FavoriteManager {
    private const val PREFS_NAME = "favorites_prefs"
    private const val KEY_FAVORITES = "favorite_foods"
    
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()
    private val favorites = mutableSetOf<String>() // Track by food name

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        loadFavorites()
    }

    private fun loadFavorites() {
        val json = sharedPreferences.getString(KEY_FAVORITES, null)
        if (json != null) {
            val type = object : TypeToken<Set<String>>() {}.type
            val saved: Set<String> = gson.fromJson(json, type) ?: emptySet()
            favorites.clear()
            favorites.addAll(saved)
        }
    }

    private fun saveFavorites() {
        val json = gson.toJson(favorites)
        sharedPreferences.edit().putString(KEY_FAVORITES, json).apply()
    }

    fun toggle(food: Food): Boolean {
        return if (favorites.contains(food.name)) {
            favorites.remove(food.name)
            saveFavorites()
            false
        } else {
            favorites.add(food.name)
            saveFavorites()
            true
        }
    }

    fun isFavorite(food: Food): Boolean {
        return favorites.contains(food.name)
    }

    fun all(): List<String> = favorites.toList()
}
