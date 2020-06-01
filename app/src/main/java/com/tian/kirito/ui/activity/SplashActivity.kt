package com.tian.kirito.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.tian.kirito.R
import com.tian.kirito.base.BasicActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Description :
 *
 * @author : create by tianp
 * @date: 2020/5/18
 */
class SplashActivity : BasicActivity() {


    override fun getLayout(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        initListener()
    }

    override fun initData() {
    }

    fun initListener() {
        // 设置动画监听
        iv_splash_lottie.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                startActivity(HomeActivity::class.java)
                finish()
            }
        })
    }
    override fun createStatusBarConfig(): ImmersionBar {
        return super.createStatusBarConfig()
            // 有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
            .fullScreen(true)
            // 隐藏状态栏
            .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
            // 透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
            .transparentNavigationBar()
    }
}