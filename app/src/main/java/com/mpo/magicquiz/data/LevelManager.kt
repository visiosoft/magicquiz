package com.mpo.magicquiz.data

import android.content.Context
import android.content.SharedPreferences

class LevelManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("LevelPrefs", Context.MODE_PRIVATE)
    
    fun isLevelUnlocked(level: Int): Boolean {
        return when (level) {
            1 -> true // Level 1 is always unlocked
            2 -> getLevelScore(1) >= 15
            3 -> getLevelScore(2) >= 15
            4 -> getLevelScore(3) >= 15
            5 -> getLevelScore(4) >= 15
            else -> false
        }
    }
    
    fun getLevelScore(level: Int): Int {
        return sharedPreferences.getInt("level_${level}_score", 0)
    }
    
    fun saveLevelScore(level: Int, score: Int) {
        sharedPreferences.edit().putInt("level_${level}_score", score).apply()
    }
    
    fun getUnlockMessage(level: Int): String {
        val previousLevel = level - 1
        val previousScore = getLevelScore(previousLevel)
        return "Score $previousScore/25 in Level $previousLevel to unlock"
    }

    fun unlockLevel(level: Int) {
        // No-op: all levels are always unlocked
    }

    companion object {
        private const val PREFS_NAME = "level_preferences"
        private const val KEY_LEVEL_2_UNLOCKED = "level_2_unlocked"
        private const val KEY_LEVEL_3_UNLOCKED = "level_3_unlocked"
        private const val KEY_LEVEL_4_UNLOCKED = "level_4_unlocked"
        private const val KEY_LEVEL_5_UNLOCKED = "level_5_unlocked"
    }
} 