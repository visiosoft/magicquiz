package com.mpo.magicquiz.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdListener
import com.mpo.magicquiz.R
import com.mpo.magicquiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()
    private var adView: AdView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Mobile Ads SDK
        MobileAds.initialize(requireContext()) { initializationStatus ->
            // Initialization complete
        }

        // Load banner ad
        loadBannerAd()

        val score = args.finalScore
        binding.textScore.text = "Your Score: $score/25"

        // Show appropriate buttons based on score
        if (score >= 15) {
            binding.buttonNextLevel.visibility = View.VISIBLE
            binding.textCongratulations.text = "Congratulations!"
        } else {
            binding.buttonTryAgain.visibility = View.VISIBLE
            binding.textCongratulations.text = "Try Again!"
        }

        // Set up button click listeners
        binding.buttonTryAgain.setOnClickListener {
            // Navigate back to the same level
            findNavController().navigateUp()
        }

        binding.buttonNextLevel.setOnClickListener {
            // Navigate to level selection
            findNavController().navigate(R.id.action_resultFragmentToLevelSelection)
        }

        binding.buttonHome.setOnClickListener {
            // Navigate to home screen
            findNavController().navigate(R.id.action_resultFragmentToHomeFragment)
        }
    }

    private fun loadBannerAd() {
        adView = AdView(requireContext()).apply {
            adUnitId = "ca-app-pub-3940256099942544/6300978111" // Test ad unit ID
            setAdSize(com.google.android.gms.ads.AdSize.BANNER)
            
            adListener = object : AdListener() {
                override fun onAdLoaded() {
                    // Ad loaded successfully
                    Toast.makeText(context, "Ad loaded successfully", Toast.LENGTH_SHORT).show()
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    // Ad failed to load
                    Toast.makeText(context, "Ad failed to load: ${loadAdError.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.adContainer.removeAllViews()
        binding.adContainer.addView(adView)
        
        val adRequest = AdRequest.Builder().build()
        adView?.loadAd(adRequest)
    }

    override fun onPause() {
        adView?.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        adView?.resume()
    }

    override fun onDestroyView() {
        adView?.destroy()
        adView = null
        _binding = null
        super.onDestroyView()
    }
} 