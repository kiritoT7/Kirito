package com.tian.kirito.base

import com.gyf.immersionbar.ImmersionBar

/**
 * Description :
 *
 * @author : create by tianp
 * @date: 2020/5/18
 */
abstract class BasicActivity : BaseActivity() {

    lateinit var mImmersionBar: ImmersionBar

    /**
     * 设置布局
     */
    override fun initLayout() {
        super.initLayout()
        initImmersion()
    }

    /**
     * 初始化沉浸式
     */
    protected open fun initImmersion() {
        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            createStatusBarConfig().init()
        }
    }

    /**
     * 是否使用沉浸式状态栏
     */
    protected open fun isStatusBarEnabled(): Boolean {
        return true
    }

    /**
     * 状态栏字体深色模式
     */
    protected open fun isStatusBarDarkFont(): Boolean {
        return true
    }

    /**
     * 初始化沉浸式状态栏
     */
    protected open fun createStatusBarConfig(): ImmersionBar {
        // 在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
            // 默认状态栏字体颜色为黑色
            .statusBarDarkFont(isStatusBarDarkFont())
        return mImmersionBar
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    fun getStatusBarConfig(): ImmersionBar? {
        return mImmersionBar
    }
}