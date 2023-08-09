package com.sundy.constraintlayout.ui.aty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.databinding.BblKeyFrameOneLayoutBinding


class KeyFrameActivity : AppCompatActivity() {
private lateinit var mBinding:BblKeyFrameOneLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= BblKeyFrameOneLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.button.setOnClickListener {
            animateToKeyframeTwo()
        }
    }

    private fun animateToKeyframeTwo() {
        var constraintSet= ConstraintSet()
        constraintSet.load(this,R.layout.bbl_key_frame_two_layout)////载入要更新的布局到constraintSet中
        TransitionManager.beginDelayedTransition(mBinding.constraint)// 开启
        constraintSet.applyTo(mBinding.constraint)
    }
}
