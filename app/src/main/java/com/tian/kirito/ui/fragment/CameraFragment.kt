package com.tian.kirito.ui.fragment

import com.tian.kirito.R
import com.tian.kirito.base.BaseFragment

/**
 * Description :
 *
 * @author : create by tianp
 * @date: 2020/5/27
 */
class CameraFragment : BaseFragment() {


    companion object {
        fun newInstance(): CameraFragment {
            return CameraFragment()
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_camera
    }

    override fun initView() {
    }

    override fun initData() {
    }
}