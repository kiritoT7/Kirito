package com.tian.kirito.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    /** 根布局  */
    private var mRootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mRootView == null && getLayoutId() > 0) {
            mRootView = inflater.inflate(getLayoutId(), null)
        }
        return mRootView
    }

    /**
     * 获取布局 ID
     */
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化控件
     */
    protected abstract fun initView()

    /**
     * 初始化数据
     */
    protected abstract fun initData()


    /**
     * 销毁当前 Fragment 所在的 Activity
     */
    fun finish() {
        activity!!.finish()
    }

    /**
     * Fragment 返回键被按下时回调
     */
    fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // 默认不拦截按键事件，回传给 Activity
        return false
    }
}