package com.example.yogiyo_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.yogiyo_clone.home.HomeFragment
import com.example.yogiyo_clone.model.BannerItem
import com.example.yogiyo_clone.model.data.fakeBannerItemList
import com.example.yogiyo_clone.model.data.fakeBannerItemList2
import com.example.yogiyo_clone.model.data.fakeGridItemList
import com.example.yogiyo_clone.model.data.fakeGridItemList2
import com.example.yogiyo_clone.mypage.MyPageFragment
import com.example.yogiyo_clone.order.OrderFragment
import com.example.yogiyo_clone.search.SearchFragment
import com.example.yogiyo_clone.star.StarFragment
import com.example.yogiyo_clone.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val tv_page_number: TextView by lazy {
        findViewById<TextView>(R.id.tv_page_number)
    }

    private val tv_page_number2: TextView by lazy {
        findViewById<TextView>(R.id.tv_page_number2)
    }

    private val viewPager2: ViewPager2 by lazy {
        findViewById<ViewPager2>(R.id.viewPager2)
    }

    private val viewPager2Two: ViewPager2 by lazy {
        findViewById<ViewPager2>(R.id.viewPager2Two)
    }

    private val notifications: ImageView by lazy {
        findViewById<ImageView>(R.id.notifications)
    }

    private val gridRecyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.gridRecyclerView)
    }

    private val foodRecyclerView: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.foodRecyclerView)
    }

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var gridRecyclerViewAdapter: GridRecyclerViewAdapter

    private lateinit var viewPagerAdapter2: ViewPagerAdapter2
    private lateinit var viewModel2: MainActivityViewModel2
    private lateinit var gridRecyclerViewAdapter2: GridRecyclerViewAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val starFragment = StarFragment()
        val searchFragment = SearchFragment()
        val orderPage = OrderFragment()
        val myPage = MyPageFragment()


        val bottomNavigationView =findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home-> replaceFragment(homeFragment)
                R.id.star-> replaceFragment(starFragment)
                R.id.search-> replaceFragment(searchFragment)
                R.id.orderPage->    replaceFragment(orderPage)
                R.id.myPage->   replaceFragment(myPage)
            }
            true
        }

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel2 = ViewModelProvider(this).get(MainActivityViewModel2::class.java)

        viewModel.setBannerItems(fakeBannerItemList)
        viewModel2.setBannerItems(fakeBannerItemList2)

        viewModel.setGridItems(fakeGridItemList)
        viewModel2.setGridItems(fakeGridItemList2)

        notifications.setOnClickListener(this)

        initViewPager2()
        initViewPager2Two()
        subscribeObservers()
        subscribeObservers2()
    }

    private fun initViewPager2() {
        viewPager2.apply {
            viewPagerAdapter = ViewPagerAdapter()
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tv_page_number.text = "${position + 1}"
                }
            })
        }
        gridRecyclerView.apply {
            gridRecyclerViewAdapter = GridRecyclerViewAdapter()
            layoutManager = GridLayoutManager(this@MainActivity, 5)

            adapter = gridRecyclerViewAdapter
        }
    }

    private fun initViewPager2Two() {
        viewPager2Two.apply {
            viewPagerAdapter2 = ViewPagerAdapter2()
            adapter = viewPagerAdapter2
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tv_page_number2.text = "${position + 1}"
                }
            })
        }
        foodRecyclerView.apply {
            gridRecyclerViewAdapter2 = GridRecyclerViewAdapter2()
            layoutManager = GridLayoutManager(this@MainActivity,1)

            adapter = gridRecyclerViewAdapter2
        }

    }


    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        })

        viewModel.gridItemList.observe(this, Observer {gridItemList->
            gridRecyclerViewAdapter.submitList(gridItemList)
        })
    }

    private fun subscribeObservers2() {
        viewModel2.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter2.submitList(bannerItemList)
        })

        viewModel2.gridItemList.observe(this, Observer {gridItemList->
            gridRecyclerViewAdapter2.submitList(gridItemList)
        })
    }




    override fun onClick(p0: View?) {
        p0?.let {
            when (it.id) {
                R.id.notifications -> {

                }
            }
        }
    }


    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }


}