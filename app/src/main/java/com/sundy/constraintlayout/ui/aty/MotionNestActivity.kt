package com.sundy.constraintlayout.ui.aty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import com.sundy.constraintlayout.R
import kotlinx.android.synthetic.main.bbl_motion_nest_layout.*

class MotionNestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bbl_motion_nest_layout)
        //initMotion()
        applyMotionWithAppBar()
    }

    private fun initMotion() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/2)
            motionLayout.progress = seekPosition
        })
    }

    private fun applyMotionWithAppBar() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/5*3)
            Log.e("MotionSampleActivity", "AppBar移动的距离：$seekPosition")
            motionLayout.progress = 1 - seekPosition
        })
    }
}
