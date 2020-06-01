package com.tian.kirito.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Description :
 *
 * @author : create by tianp
 * @date: 2020/5/18
 */
class NoHorizontalScrollerViewPager : ViewPager {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun executeKeyEvent(event: KeyEvent): Boolean {
        return false
    }

    override fun setCurrentItem(item: Int) {
        var smoothScroller = false
        val currentItem = currentItem
        smoothScroller = when (currentItem) {
            0 -> // 如果当前是第一页，只有第二页才会有动画
                item == currentItem + 1
            (getCount() - 1) -> // 如果当前是最后一页，只有最后第二页才会有动画
                item == currentItem + 1
            else -> // 如果当前是中间页，只有相邻页才会有动画
                Math.abs(currentItem - item) == 1
        }
        super.setCurrentItem(item, smoothScroller)
    }

    fun getCount(): Int {
        val adapter = adapter
        return adapter?.count ?: 0
    }
}