package com.sundy.constraintlayout.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager

class ViewpagerHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), ViewPager.OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val animateProgress = (position.toFloat() + positionOffset)/3
        Log.e("LottieMotionActivity", "viewpager scroll progress is: $animateProgress")
        progress = animateProgress
    }

    override fun onPageSelected(position: Int) {
    }
}