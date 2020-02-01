package com.sundy.constraintlayout.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener

/**
 * 项目名称：ConstraintLayout
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-02-01 13:20
 * 描述：
 */
class MotionToolBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): MotionLayout(context,attrs,defStyleAttr), OnOffsetChangedListener {


    override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {

        //progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
        val seekPosition = -verticalOffset / (appBarLayout?.totalScrollRange!!.toFloat()/5*3)
        progress = 1 - seekPosition
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}