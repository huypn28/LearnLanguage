package com.example.learnlanguage.fragment

import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.example.learnlanguage.R
import com.example.learnlanguage.adapter.HomePagerAdapter
import com.example.learnlanguage.base.BaseFragment
import com.example.learnlanguage.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var homePagerAdapter: HomePagerAdapter
    companion object {
        internal val TAG = HomeFragment::class.java.name
    }

    override fun getVM(): ViewModel {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        homePagerAdapter = HomePagerAdapter(requireActivity())
        binding.viewpager2Home.adapter = homePagerAdapter
        binding.viewpager2Home.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })
        binding.layoutBottomBar.setOnItemSelectedListener { item ->

            true
        }
    }

    override fun getLayoutId() = R.layout.fragment_home
}