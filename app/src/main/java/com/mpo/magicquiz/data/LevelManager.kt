package com.mpo.magicquiz.data

import android.content.Context
import android.content.SharedPreferences

class LevelManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isLevelUnlocked(level: Int): Boolean {
        return when (level) {
            1 -> true // Level 1 is always unlocked
            2 -> sharedPreferences.getBoolean(KEY_LEVEL_2_UNLOCKED, false)
            3 -> sharedPreferences.getBoolean(KEY_LEVEL_3_UNLOCKED, false)
            else -> false
        }
    }

    fun unlockLevel(level: Int) {
        when (level) {
            2 -> sharedPreferences.edit().putBoolean(KEY_LEVEL_2_UNLOCKED, true).apply()
            3 -> sharedPreferences.edit().putBoolean(KEY_LEVEL_3_UNLOCKED, true).apply()
        }
    }

    companion object {
        private const val PREFS_NAME = "level_preferences"
        private const val KEY_LEVEL_2_UNLOCKED = "level_2_unlocked"
        private const val KEY_LEVEL_3_UNLOCKED = "level_3_unlocked"
    }
} 