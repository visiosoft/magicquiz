package com.mpo.magicquiz.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.mpo.magicquiz.R
import com.mpo.magicquiz.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private val args: QuestionFragmentArgs by navArgs()
    private val viewModel: QuestionViewModel by viewModels()
    private var rewardedAd: RewardedAd? = null
    private var interstitialAd: InterstitialAd? = null
    private var adView: AdView? = null
    private var nativeAd: NativeAd? = null
    private var questionCount = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Mobile Ads SDK
        MobileAds.initialize(requireContext())

        // Load ads
        loadRewardedAd()
        loadInterstitialAd()
        loadBannerAd()

        // Set the level in ViewModel
        viewModel.setLevel(args.level)
        binding.textLevel.text = "Level ${args.level}"

        // Observe current question
        viewModel.currentQuestion.observe(viewLifecycleOwner) { question ->
            question?.let {
                binding.textQuestion.text = it.question
                binding.textQuestionNumber.text = "Question ${viewModel.questionNumber.value}/${viewModel.totalQuestions.value}"
                
                // Reset UI state for new question
                binding.textFeedback.visibility = View.GONE
                binding.hintContainer.visibility = View.GONE
                enableAllAnswerButtons()
                
                // Update answer buttons
                for (i in 0 until binding.answerContainer.childCount) {
                    val button = binding.answerContainer.getChildAt(i) as Button
                    if (i < it.options.size) {
                        button.text = it.options[i]
                        button.visibility = View.VISIBLE
                        button.isEnabled = true
                        button.setOnClickListener { _ ->
                            handleAnswer(i)
                        }
                    } else {
                        button.visibility = View.GONE
                    }
                }
            }
        }

        // Observe native ad
        viewModel.nativeAd.observe(viewLifecycleOwner) { ad ->
            nativeAd?.destroy()
            nativeAd = ad
            if (ad != null) {
                populateNativeAdView(ad)
            }
        }

        // Observe score
        viewModel.score.observe(viewLifecycleOwner) { score ->
            binding.textScore.text = "Score: $score"
        }

        // Observe level completion
        viewModel.isLevelComplete.observe(viewLifecycleOwner) { isComplete ->
            if (isComplete) {
                val feedback = viewModel.feedback.value ?: "Level Complete!"
                // Show feedback message
                Toast.makeText(context, feedback, Toast.LENGTH_LONG).show()
                
                // Navigate to result screen with score
                val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(
                    finalScore = viewModel.score.value ?: 0
                )
                findNavController().navigate(action)
            }
        }

        // Observe interstitial ad flag
        viewModel.showInterstitial.observe(viewLifecycleOwner) { showAd ->
            if (showAd) {
                showInterstitialAd()
            }
        }

        // Set up hint button
        binding.buttonHint.setOnClickListener {
            showRewardedAd()
        }
    }

    private fun populateNativeAdView(nativeAd: NativeAd) {
        // Create a new NativeAdView
        val nativeAdView = layoutInflater.inflate(
            R.layout.native_ad_layout,
            binding.nativeAdContainer,
            false
        ) as NativeAdView

        // Set the native ad view attributes
        nativeAdView.headlineView = nativeAdView.findViewById(R.id.ad_headline)
        nativeAdView.bodyView = nativeAdView.findViewById(R.id.ad_body)
        nativeAdView.callToActionView = nativeAdView.findViewById(R.id.ad_call_to_action)
        nativeAdView.iconView = nativeAdView.findViewById(R.id.ad_icon)
        nativeAdView.priceView = nativeAdView.findViewById(R.id.ad_price)
        nativeAdView.starRatingView = nativeAdView.findViewById(R.id.ad_stars)
        nativeAdView.storeView = nativeAdView.findViewById(R.id.ad_store)
        nativeAdView.advertiserView = nativeAdView.findViewById(R.id.ad_advertiser)

        // Populate the native ad view
        (nativeAdView.headlineView as TextView).text = nativeAd.headline
        nativeAd.headline?.let { nativeAdView.headlineView?.visibility = View.VISIBLE }

        if (nativeAd.body == null) {
            nativeAdView.bodyView?.visibility = View.INVISIBLE
        } else {
            nativeAdView.bodyView?.visibility = View.VISIBLE
            (nativeAdView.bodyView as TextView).text = nativeAd.body
        }

        if (nativeAd.callToAction == null) {
            nativeAdView.callToActionView?.visibility = View.INVISIBLE
        } else {
            nativeAdView.callToActionView?.visibility = View.VISIBLE
            (nativeAdView.callToActionView as Button).text = nativeAd.callToAction
        }

        if (nativeAd.icon == null) {
            nativeAdView.iconView?.visibility = View.GONE
        } else {
            (nativeAdView.iconView as ImageView).setImageDrawable(nativeAd.icon?.drawable)
            nativeAdView.iconView?.visibility = View.VISIBLE
        }

        if (nativeAd.price == null) {
            nativeAdView.priceView?.visibility = View.INVISIBLE
        } else {
            nativeAdView.priceView?.visibility = View.VISIBLE
            (nativeAdView.priceView as TextView).text = nativeAd.price
        }

        if (nativeAd.store == null) {
            nativeAdView.storeView?.visibility = View.INVISIBLE
        } else {
            nativeAdView.storeView?.visibility = View.VISIBLE
            (nativeAdView.storeView as TextView).text = nativeAd.store
        }

        if (nativeAd.starRating == null) {
            nativeAdView.starRatingView?.visibility = View.INVISIBLE
        } else {
            (nativeAdView.starRatingView as RatingBar).rating = nativeAd.starRating!!.toFloat()
            nativeAdView.starRatingView?.visibility = View.VISIBLE
        }

        if (nativeAd.advertiser == null) {
            nativeAdView.advertiserView?.visibility = View.INVISIBLE
        } else {
            (nativeAdView.advertiserView as TextView).text = nativeAd.advertiser
            nativeAdView.advertiserView?.visibility = View.VISIBLE
        }

        // Clear the native ad container and add the new native ad view
        binding.nativeAdContainer.removeAllViews()
        binding.nativeAdContainer.addView(nativeAdView)

        // Register the native ad view
        nativeAdView.setNativeAd(nativeAd)
    }

    private fun loadBannerAd() {
        adView = AdView(requireContext()).apply {
            adUnitId = "ca-app-pub-3940256099942544/6300978111" // Test ad unit ID
            setAdSize(com.google.android.gms.ads.AdSize.BANNER)
            
            adListener = object : com.google.android.gms.ads.AdListener() {
                override fun onAdLoaded() {
                    // Ad loaded successfully
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    // Ad failed to load
                }
            }
        }

        binding.bannerAdContainer.removeAllViews()
        binding.bannerAdContainer.addView(adView)
        
        val adRequest = AdRequest.Builder().build()
        adView?.loadAd(adRequest)
    }

    private fun loadRewardedAd() {
        val adRequest = AdRequest.Builder().build()
        RewardedAd.load(
            requireContext(),
            "ca-app-pub-3940256099942544/5224354917", // Test ad unit ID
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    rewardedAd = null
                }
            }
        )
    }

    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            requireContext(),
            "ca-app-pub-3940256099942544/1033173712", // Test interstitial ad unit ID
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                }
            }
        )
    }

    private fun showRewardedAd() {
        if (rewardedAd != null) {
            rewardedAd?.show(requireActivity()) { rewardItem ->
                // Show hint after ad is watched
                binding.hintContainer.visibility = View.VISIBLE
                binding.textHint.text = viewModel.getHint()
                // Load the next ad
                loadRewardedAd()
            }
        } else {
            // If ad is not loaded, show hint anyway
            binding.hintContainer.visibility = View.VISIBLE
            binding.textHint.text = viewModel.getHint()
            // Try to load the next ad
            loadRewardedAd()
        }
    }

    private fun showInterstitialAd() {
        val interstitialAd = viewModel.getInterstitialAd()
        if (interstitialAd != null) {
            interstitialAd.show(requireActivity())
            viewModel.resetInterstitialFlag()
        } else {
            // If ad is not loaded, navigate to result screen
            navigateToResult()
        }
    }

    private fun navigateToResult() {
        val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(
            finalScore = viewModel.score.value ?: 0
        )
        findNavController().navigate(action)
    }

    private fun handleAnswer(selectedAnswer: Int) {
        val isCorrect = viewModel.checkAnswer(selectedAnswer)
        disableAllAnswerButtons()
        
        // Show feedback
        binding.textFeedback.apply {
            text = if (isCorrect) "Correct!" else "Wrong!"
            setTextColor(ContextCompat.getColor(requireContext(), 
                if (isCorrect) R.color.correct else R.color.wrong))
            visibility = View.VISIBLE
        }

        // Delay before next question
        view?.postDelayed({
            viewModel.nextQuestion()
        }, 1000)
    }

    private fun enableAllAnswerButtons() {
        for (i in 0 until binding.answerContainer.childCount) {
            val button = binding.answerContainer.getChildAt(i) as Button
            button.isEnabled = true
        }
    }

    private fun disableAllAnswerButtons() {
        for (i in 0 until binding.answerContainer.childCount) {
            val button = binding.answerContainer.getChildAt(i) as Button
            button.isEnabled = false
        }
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
        nativeAd?.destroy()
        adView?.destroy()
        adView = null
        _binding = null
        super.onDestroyView()
    }
} 