package com.mpo.magicquiz.ads

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdListener

class BannerAdManager(private val context: Context) {
    init {
        MobileAds.initialize(context) { initializationStatus ->
            Log.d("BannerAdManager", "MobileAds initialization status: $initializationStatus")
            // Log each adapter's initialization status
            initializationStatus.adapterStatusMap.forEach { (adapter, status) ->
                Log.d("BannerAdManager", "Adapter: $adapter, Status: ${status.initializationState}")
            }
        }
    }

    fun loadBannerAd(adView: AdView) {
        Log.d("BannerAdManager", "Starting to load banner ad")
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        adView.adListener = object : AdListener() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                Log.e("BannerAdManager", "Ad failed to load: ${loadAdError.message}")
                Log.e("BannerAdManager", "Error code: ${loadAdError.code}")
                Log.e("BannerAdManager", "Error domain: ${loadAdError.domain}")
                adView.visibility = android.view.View.GONE
            }

            override fun onAdLoaded() {
                Log.d("BannerAdManager", "Ad loaded successfully")
                adView.visibility = android.view.View.VISIBLE
            }

            override fun onAdOpened() {
                Log.d("BannerAdManager", "Ad opened")
            }

            override fun onAdClosed() {
                Log.d("BannerAdManager", "Ad closed")
            }

            override fun onAdImpression() {
                Log.d("BannerAdManager", "Ad impression recorded")
            }

            override fun onAdClicked() {
                Log.d("BannerAdManager", "Ad clicked")
            }
        }
    }
} 