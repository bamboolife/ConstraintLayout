package com.sundy.constraintlayout.ui.aty

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.sundy.constraintlayout.databinding.BblMotionNestLayoutBinding


class MotionNestActivity : AppCompatActivity() {
private lateinit var mBinding:BblMotionNestLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= BblMotionNestLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        //initMotion()
        applyMotionWithAppBar()
    }

    private fun initMotion() {
        mBinding.appBarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            val seekPosition =
                -verticalOffset / (mBinding.appBarLayout.totalScrollRange.toFloat() / 2)
            mBinding.motionLayout.progress = seekPosition
        }
    }

    private fun applyMotionWithAppBar() {
        mBinding.appBarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            val seekPosition =
                -verticalOffset / (mBinding.appBarLayout.totalScrollRange.toFloat() / 5 * 3)
            Log.e("MotionSampleActivity", "AppBar移动的距离：$seekPosition")
            mBinding.motionLayout.progress = 1 - seekPosition
        }
    }
}
