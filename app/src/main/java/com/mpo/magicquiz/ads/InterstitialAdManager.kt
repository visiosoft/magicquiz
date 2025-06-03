package com.mpo.magicquiz.ads

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialAdManager(private val context: Context) {
    private var interstitialAd: InterstitialAd? = null
    private var onAdDismissedCallback: (() -> Unit)? = null

    init {
        MobileAds.initialize(context) { initializationStatus ->
            Log.d("InterstitialAdManager", "MobileAds initialization status: $initializationStatus")
        }
        loadInterstitialAd()
    }

    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712", // Test ad unit ID
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.e("InterstitialAdManager", "Ad failed to load: ${loadAdError.message}")
                    interstitialAd = null
                }

                override fun onAdLoaded(ad: InterstitialAd) {
                    Log.d("InterstitialAdManager", "Ad loaded successfully")
                    interstitialAd = ad
                }
            }
        )
    }

    fun showInterstitialAd(onAdDismissed: () -> Unit) {
        onAdDismissedCallback = onAdDismissed
        interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d("InterstitialAdManager", "Ad dismissed")
                interstitialAd = null
                loadInterstitialAd() // Load the next ad
                onAdDismissedCallback?.invoke()
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.e("InterstitialAdManager", "Ad failed to show: ${adError.message}")
                interstitialAd = null
                loadInterstitialAd() // Load the next ad
                onAdDismissedCallback?.invoke()
            }
        }

        interstitialAd?.show(context as android.app.Activity) ?: run {
            Log.d("InterstitialAdManager", "Ad not loaded, skipping show")
            // If ad is not loaded, still invoke the callback
            onAdDismissedCallback?.invoke()
        }
    }
} 