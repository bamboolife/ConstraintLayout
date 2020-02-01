package com.sundy.constraintlayout.ui.aty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.ui.home.PageFragment
import kotlinx.android.synthetic.main.bbl_lottie_motion_layout.*

class LottieMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bbl_lottie_motion_layout)
        applyViewPagerMotion()
    }

    private fun applyViewPagerMotion() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addPage("Now", R.layout.bbl_holder_layout)
        adapter.addPage("Discover", R.layout.bbl_holder_layout)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(header as ViewPager.OnPageChangeListener)
        //header.setDebugMode(MotionLayout.DEBUG_SHOW_PROGRESS)
        // todo: fix problem of beta2 version library with lottie not works and cant set debugMode
        // Now lottie can do the same effect with viewpager
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, offsetPixels: Int) {
                val animateProgress = position.toFloat() + positionOffset
                Log.e("LottieMotionActivity", "viewpager scroll progress is: $animateProgress")
                lottieView.progress = animateProgress / 3
            }

            override fun onPageSelected(p0: Int) {
            }

        })
    }
}
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    private fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    fun addPage(s: String, layout: Int) {
        val page = PageFragment()
        val arg = Bundle()
        arg.putInt("layout", layout)
        page.arguments = arg
        addFragment(page, s)
    }
}