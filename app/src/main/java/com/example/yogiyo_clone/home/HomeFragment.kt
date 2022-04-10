package com.example.yogiyo_clone.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.yogiyo_clone.R
import com.example.yogiyo_clone.ui.*

class HomeFragment:Fragment(R.layout.fragment_home) {



    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var gridRecyclerViewAdapter: GridRecyclerViewAdapter

    private lateinit var viewPagerAdapter2: ViewPagerAdapter2
    private lateinit var viewModel2: MainActivityViewModel2
    private lateinit var gridRecyclerViewAdapter2: GridRecyclerViewAdapter2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}