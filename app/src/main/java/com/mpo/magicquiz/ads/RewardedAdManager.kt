package com.mpo.magicquiz.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class RewardedAdManager(private val context: Context) {
    private var rewardedAd: RewardedAd? = null
    private var onRewardedCallback: (() -> Unit)? = null

    init {
        MobileAds.initialize(context) { initializationStatus ->
            Log.d("RewardedAdManager", "MobileAds initialization status: $initializationStatus")
            // Log each adapter's initialization status
            initializationStatus.adapterStatusMap.forEach { (adapter, status) ->
                Log.d("RewardedAdManager", "Adapter: $adapter, Status: ${status.initializationState}")
            }
        }
        loadRewardedAd()
    }

    private fun loadRewardedAd() {
        Log.d("RewardedAdManager", "Starting to load rewarded ad")
        val adRequest = AdRequest.Builder().build()
        RewardedAd.load(
            context,
            "ca-app-pub-3940256099942544/5224354917", // Test ad unit ID
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.e("RewardedAdManager", "Ad failed to load: ${loadAdError.message}")
                    Log.e("RewardedAdManager", "Error code: ${loadAdError.code}")
                    Log.e("RewardedAdManager", "Error domain: ${loadAdError.domain}")
                    rewardedAd = null
                }

                override fun onAdLoaded(ad: RewardedAd) {
                    Log.d("RewardedAdManager", "Ad loaded successfully")
                    rewardedAd = ad
                }
            }
        )
    }

    fun showRewardedAd(activity: Activity, onRewarded: () -> Unit) {
        Log.d("RewardedAdManager", "Attempting to show rewarded ad")
        onRewardedCallback = onRewarded
        
        if (rewardedAd == null) {
            Log.d("RewardedAdManager", "Ad not loaded, loading a new one")
            loadRewardedAd()
            // Still give the reward if ad is not loaded
            onRewardedCallback?.invoke()
            return
        }

        rewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d("RewardedAdManager", "Ad dismissed")
                rewardedAd = null
                loadRewardedAd() // Load the next ad
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.e("RewardedAdManager", "Ad failed to show: ${adError.message}")
                Log.e("RewardedAdManager", "Error code: ${adError.code}")
                Log.e("RewardedAdManager", "Error domain: ${adError.domain}")
                rewardedAd = null
                loadRewardedAd() // Load the next ad
                // If ad fails to show, still give the reward
                onRewardedCallback?.invoke()
            }

            override fun onAdShowedFullScreenContent() {
                Log.d("RewardedAdManager", "Ad showed successfully")
            }

            override fun onAdImpression() {
                Log.d("RewardedAdManager", "Ad impression recorded")
            }
        }

        rewardedAd?.show(activity) { rewardItem ->
            Log.d("RewardedAdManager", "User earned reward: ${rewardItem.amount} ${rewardItem.type}")
            // Handle the reward
            onRewardedCallback?.invoke()
        } ?: run {
            Log.d("RewardedAdManager", "Ad not loaded, skipping show")
            // If ad is not loaded, still give the reward
            onRewardedCallback?.invoke()
        }
    }
} 