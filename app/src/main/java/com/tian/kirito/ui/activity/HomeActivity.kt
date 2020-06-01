package com.tian.kirito.ui.activity

import com.tian.kirito.R
import com.tian.kirito.base.BaseActivity
import com.tian.kirito.base.BaseFragment
import com.tian.kirito.base.BaseFragmentAdapter
import com.tian.kirito.ui.fragment.CameraFragment
import com.tian.kirito.ui.fragment.MineFragment
import com.tian.kirito.ui.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Description :
 *
 * @author : create by tianp
 * @date: 2020/5/18
 */
class HomeActivity : BaseActivity() {


    private lateinit var mPagerAdapter: BaseFragmentAdapter<BaseFragment>


    override fun getLayout(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        initListener()
    }

    override fun initData() {
        mPagerAdapter = BaseFragmentAdapter(this)
        mPagerAdapter.addFragment(MineFragment.newInstance())
        mPagerAdapter.addFragment(CameraFragment.newInstance())
        mPagerAdapter.addFragment(VideoFragment.newInstance())
        mPagerAdapter.addFragment(MineFragment.newInstance())

        viewpager_home.adapter = mPagerAdapter
        viewpager_home.offscreenPageLimit = mPagerAdapter.count
    }

    fun initListener() {
        nav_home.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> {
                    mPagerAdapter.setCurrentItem(MineFragment::class.java)
                    true
                }
                R.id.item_camera -> {
                    mPagerAdapter.setCurrentItem(CameraFragment::class.java)
                    true
                }
                R.id.item_video -> {
                    mPagerAdapter.setCurrentItem(VideoFragment::class.java)
                    true
                }
                R.id.item_my -> {
                    mPagerAdapter.setCurrentItem(MineFragment::class.java)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}