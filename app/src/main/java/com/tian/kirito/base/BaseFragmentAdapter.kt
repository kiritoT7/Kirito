package com.tian.kirito.base

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager


class BaseFragmentAdapter<F : Fragment> : FragmentPagerAdapter {

    /** Fragment集合 */
    private var mFragmentSet = arrayListOf<F>()
    /** 当前显示的Fragment */
    private var mCurrentFragment: F? = null
    /** 当前 ViewPager  */
    private var mViewPager: ViewPager? = null

    constructor(activity: FragmentActivity) : this(activity.supportFragmentManager)
    constructor(fragment: Fragment) : this(fragment.childFragmentManager)
    constructor(manager: FragmentManager) : this(
        manager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    )

    constructor(manager: FragmentManager, behavior: Int) : super(manager, behavior)


    override fun getItem(position: Int): Fragment {
        return mFragmentSet[position]
    }

    override fun getCount(): Int {
        return mFragmentSet.size
    }

    override fun setPrimaryItem(container: View, position: Int, `object`: Any) {
        if (getCurrentFragment() != `object`) {
            mCurrentFragment = `object` as F
        }
        super.setPrimaryItem(container, position, `object`)
    }
    /**
     * 添加一个fragment
     */
    fun addFragment(fragment: F) {
        mFragmentSet.add(fragment)
    }

    /**
     * 获取fragment集合
     */
    fun getAllFragment(): ArrayList<F> {
        return mFragmentSet
    }

    fun getCurrentFragment(): F? {
        return mCurrentFragment
    }

    override fun startUpdate(container: ViewGroup) {
        super.startUpdate(container)
        if (container is ViewPager) {
            // 记录绑定 ViewPager
            mViewPager = container
        }
    }

    /**
     * 设置当前条目
     *
     * @param clazz             欲切换的 Fragment
     */
    fun setCurrentItem(clazz: Class<out F>) {
        for (i in mFragmentSet.indices) {
            if (mFragmentSet[i].javaClass == clazz) {
                setCurrentItem(i)
                break
            }
        }
    }

    fun setCurrentItem(position: Int) {
        mViewPager!!.setCurrentItem(position)
    }

    fun setCurrentItem(position: Int, smoothScroll: Boolean) {
        mViewPager!!.setCurrentItem(position, smoothScroll)
    }
}