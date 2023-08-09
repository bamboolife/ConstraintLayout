package com.sundy.constraintlayout.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.adapter.MotionAdapter
import com.sundy.constraintlayout.bean.MotionBean
import com.sundy.constraintlayout.ui.notifications.NotificationsViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var mAdapter: MotionAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        homeViewModel.datas.observe(viewLifecycleOwner, Observer {
            mAdapter = MotionAdapter(R.layout.bbl_motion_item_layout, it)
            recyclerView.adapter = mAdapter
            mAdapter?.setOnItemClickListener { adapter, _, position ->
                val bean = adapter.getItem(position) as MotionBean
                startActivity(Intent(context, bean.clazz))
            }
        })

        return root
    }

}