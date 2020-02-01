package com.sundy.constraintlayout.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.bean.MotionBean
import com.sundy.constraintlayout.ui.aty.*

class HomeViewModel : ViewModel() {

    private val _datas = MutableLiveData<MutableList<MotionBean>>().apply {
        value = arrayListOf(
           MotionBean(R.mipmap.ic_base, "Motion applies in basement", MotionSampleActivity::class.java),
           MotionBean(R.mipmap.ic_multi, "Motion applies with multi targets", MultiBallActivity::class.java),
           MotionBean(R.mipmap.ic_appbar, "Motion applies with AppBar", AppBarMotionActivity::class.java),
           MotionBean(R.mipmap.ic_drawer, "Motion applies with Drawer", DrawerMotionActivity::class.java),
           MotionBean(R.mipmap.ic_pager, "Motion applies with ViewPager", LottieMotionActivity::class.java),
           MotionBean(R.mipmap.ic_pager, "ARC Menu", ArcMenuActivity::class.java),
           MotionBean(R.mipmap.ic_pager, "Windmill", WindmillActivity::class.java),
           MotionBean(R.mipmap.ic_pager, "Motion 使用测试", MotionNestActivity::class.java)

        )
    }
    val datas: LiveData<MutableList<MotionBean>> = _datas
}