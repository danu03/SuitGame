package com.danusuhendra.suitgame

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AdapterViewPager(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    val fragment = listOf(Landing1Fragment(), Landing2Fragment(), Landing3Fragment())

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getCount(): Int {
        return fragment.size
    }
}