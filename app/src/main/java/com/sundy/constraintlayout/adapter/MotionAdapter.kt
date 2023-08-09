package com.sundy.constraintlayout.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sundy.constraintlayout.R
import com.sundy.constraintlayout.bean.MotionBean


/**
 *项目名称：ConstraintLayout
 *@Author bamboolife
 *邮箱：core_it@163.com
 *创建时间：2020-01-31 22:26
 *描述：
 */
class MotionAdapter(layoutResId: Int, data: MutableList<MotionBean>?) : BaseQuickAdapter<MotionBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: MotionBean) {
        holder.setText(R.id.tv_title, item.title)
        holder.setImageResource(R.id.entrance_item_ic, item.resId)
    }
}