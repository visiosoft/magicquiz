package com.mpo.magicquiz.ads

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdListener

class BannerAdManager(private val context: Context) {
    init {
        MobileAds.initialize(context)
    }

    fun loadBannerAd(adView: AdView) {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        adView.adListener = object : AdListener() {
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                // Handle ad load failure
                adView.visibility = android.view.View.GONE
            }

            override fun onAdLoaded() {
                // Ad loaded successfully
                adView.visibility = android.view.View.VISIBLE
            }
        }
    }
} 