package com.sundy.constraintlayout.ui.aty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.AppBarLayout
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.databinding.BblAppBarMotionLayoutBinding

class AppBarMotionActivity : AppCompatActivity() {
private lateinit var mBinding:BblAppBarMotionLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= BblAppBarMotionLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        applyMotionWithAppBar()
    }


    private fun applyMotionWithAppBar() {
        mBinding.appBarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            val seekPosition =
                -verticalOffset / (mBinding.appBarLayout.totalScrollRange.toFloat() / 5 * 3)
            mBinding.motionLayout.progress = 1 - seekPosition
        }
    }
}
