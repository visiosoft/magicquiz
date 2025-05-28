package com.mpo.magicquiz.ui.quiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.mpo.magicquiz.R

class AnswerFeedbackOverlay(
    private val context: Context,
    private val parent: ViewGroup
) {
    private val overlayView: View
    private val animationView: LottieAnimationView
    private val feedbackText: TextView
    private val emojiText: TextView

    init {
        overlayView = LayoutInflater.from(context).inflate(R.layout.answer_feedback_overlay, parent, false)
        animationView = overlayView.findViewById(R.id.animation_view)
        feedbackText = overlayView.findViewById(R.id.feedback_text)
        emojiText = overlayView.findViewById(R.id.emoji_text)
    }

    fun showCorrectAnswer(onAnimationEnd: () -> Unit) {
        animationView.setAnimation(R.raw.correct_sparkles)
        feedbackText.text = "Correct!"
        emojiText.text = "🎯"
        emojiText.visibility = View.VISIBLE
        
        showOverlay {
            animationView.playAnimation()
            feedbackText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
            emojiText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
            
            animationView.addAnimatorListener(object : android.animation.AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: android.animation.Animator) {
                    hideOverlay {
                        onAnimationEnd()
                    }
                }
            })
        }
    }

    fun showWrongAnswer(onAnimationEnd: () -> Unit) {
        animationView.setAnimation(R.raw.wrong_puff)
        feedbackText.text = "Wrong!"
        emojiText.text = "❌"
        emojiText.visibility = View.VISIBLE
        
        showOverlay {
            animationView.playAnimation()
            feedbackText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
            emojiText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
            
            animationView.addAnimatorListener(object : android.animation.AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: android.animation.Animator) {
                    hideOverlay {
                        onAnimationEnd()
                    }
                }
            })
        }
    }

    private fun showOverlay(onShown: () -> Unit) {
        if (overlayView.parent == null) {
            parent.addView(overlayView)
            overlayView.alpha = 0f
            overlayView.animate()
                .alpha(1f)
                .setDuration(200)
                .withEndAction { onShown() }
        }
    }

    private fun hideOverlay(onHidden: () -> Unit) {
        overlayView.animate()
            .alpha(0f)
            .setDuration(200)
            .withEndAction {
                parent.removeView(overlayView)
                onHidden()
            }
    }
} 