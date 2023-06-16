package com.example.tutorialapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class CustomPagerAdapter(fm :FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fm,lifecycle) {
    private val arrayList: ArrayList<Fragment> = ArrayList()


    override fun getItemCount(): Int {
        return arrayList.count();
    }

    override fun createFragment(position: Int): Fragment {
        return arrayList.get(position);
    }

    fun addFragment(fragment: Fragment?) {
        fragment?.let { arrayList.add(it) }
    }
}