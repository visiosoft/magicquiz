package com.mpo.magicquiz.ads

import android.app.Activity
import android.content.Context
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
        MobileAds.initialize(context)
        loadRewardedAd()
    }

    private fun loadRewardedAd() {
        val adRequest = AdRequest.Builder().build()
        // Replace with your actual ad unit ID
        RewardedAd.load(
            context,
            "ca-app-pub-3940256099942544/5224354917", // Test ad unit ID
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    rewardedAd = null
                }

                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                }
            }
        )
    }

    fun showRewardedAd(activity: Activity, onRewarded: () -> Unit) {
        onRewardedCallback = onRewarded
        rewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                rewardedAd = null
                loadRewardedAd() // Load the next ad
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                rewardedAd = null
                loadRewardedAd() // Load the next ad
                // If ad fails to show, still give the reward
                onRewardedCallback?.invoke()
            }

            override fun onAdShowedFullScreenContent() {
                // Ad showed successfully
            }
        }

        rewardedAd?.show(activity) { rewardItem ->
            // Handle the reward
            onRewardedCallback?.invoke()
        } ?: run {
            // If ad is not loaded, still give the reward
            onRewardedCallback?.invoke()
        }
    }
} 