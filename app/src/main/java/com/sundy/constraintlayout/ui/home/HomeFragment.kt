package com.sundy.constraintlayout.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.adapter.MotionAdapter
import com.sundy.constraintlayout.bean.MotionBean

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var mAdapter:MotionAdapter?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        var recyclerView:RecyclerView=root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        mAdapter= MotionAdapter(R.layout.bbl_motion_item_layout,null)
        recyclerView.adapter=mAdapter
        homeViewModel.datas.observe(this, Observer {
            mAdapter!!.setNewData(it)
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAdapter?.setOnItemClickListener { adapter, _, position ->
            run {
                val bean = adapter.getItem(position) as MotionBean
                startActivity(Intent(context, bean.clazz))

            }
        }
    }
}