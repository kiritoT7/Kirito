package com.tian.kirito.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

/**
 * Description :
 *
 * @author : create by tianp
 * @date: 2020/5/13
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()
    }

    /**
     * 构建activity类
     */
    private fun initActivity() {
        initLayout()
        initView()
        initData()
    }

    /**
     * 获取布局id
     */
    protected abstract fun getLayout(): Int

    /**
     * 初始化view
     */
    protected abstract fun initView()

    /**
     * 初始化view
     */
    protected abstract fun initData()

    /**
     * 设置布局
     */
    @Override
    open fun initLayout() {
        if (getLayout() > 0) {
            setContentView(getLayout())
        }
    }

    /**
     * 获取当前activity
     */
    protected fun getActivity(): BaseActivity {
        return this
    }

    /**
     * 跳转activity方法
     */
    fun startActivity(clazz: Class<out Activity>) {
        startActivity(Intent(this, clazz))
    }

    /**
     * 隐藏软键盘
     */
    private fun hideSoftKeyboard() {
        val view = currentFocus!!
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}