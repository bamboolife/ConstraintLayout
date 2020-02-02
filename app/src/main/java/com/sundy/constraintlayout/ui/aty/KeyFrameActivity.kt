package com.sundy.constraintlayout.ui.aty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager
import com.sundy.constraintlayout.R
import kotlinx.android.synthetic.main.bbl_key_frame_one_layout.*

class KeyFrameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bbl_key_frame_one_layout)
        button.setOnClickListener(View.OnClickListener {
            animateToKeyframeTwo()
        })
    }

    private fun animateToKeyframeTwo() {
        var constraintSet= ConstraintSet()
        constraintSet.load(this,R.layout.bbl_key_frame_two_layout)////载入要更新的布局到constraintSet中
        TransitionManager.beginDelayedTransition(constraint)// 开启
        constraintSet.applyTo(constraint)
    }
}
