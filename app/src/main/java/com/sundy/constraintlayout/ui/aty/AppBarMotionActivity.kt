package com.sundy.constraintlayout.ui.aty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.AppBarLayout
import com.sundy.constraintlayout.R
import kotlinx.android.synthetic.main.bbl_app_bar_motion_layout.*

class AppBarMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bbl_app_bar_motion_layout)
        applyMotionWithAppBar()
    }


    private fun applyMotionWithAppBar() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/5*3)
            motionLayout.progress = 1 - seekPosition
        })
    }
}
