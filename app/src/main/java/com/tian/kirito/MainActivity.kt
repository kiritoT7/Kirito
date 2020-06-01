package com.tian.kirito

import com.tian.kirito.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {
        println(getActivity())
    }
}
