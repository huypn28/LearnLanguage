package com.example.learnlanguage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learnlanguage.fragment.FolderFragment
import com.example.learnlanguage.fragment.ProfileFragment

class HomePagerAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
           // 0 -> FolderFragment()
            //1 -> TopicFragment()
            //2 -> PublicFragment()
            3 -> ProfileFragment()
            else -> ProfileFragment()
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}