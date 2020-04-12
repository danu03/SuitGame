package com.danusuhendra.suitgame.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.danusuhendra.suitgame.LandingPage.Landing1Fragment
import com.danusuhendra.suitgame.LandingPage.Landing2Fragment
import com.danusuhendra.suitgame.LandingPage.Landing3Fragment

class AdapterViewPager(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    val fragment = listOf(
        Landing1Fragment(),
        Landing2Fragment(),
        Landing3Fragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getCount(): Int {
        return fragment.size
    }
}