package com.example.yogiyo_clone.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yogiyo_clone.model.BannerItem
import com.example.yogiyo_clone.model.GridItem

class MainActivityViewModel2 : ViewModel() {
    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()
    private val _gridItemList: MutableLiveData<List<GridItem>> = MutableLiveData()
    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()

    val bannerItemList: LiveData<List<BannerItem>>
        get() = _bannerItemList
    val gridItemList: LiveData<List<GridItem>>
        get() = _gridItemList
    val currentPosition: LiveData<Int>
        get() = _currentPosition


    init{
        _currentPosition.value=0
    }

    fun setBannerItems(list: List<BannerItem>) {
        _bannerItemList.value = list
    }
    fun setGridItems(list: List<GridItem>) {
        _gridItemList.value = list
    }

    fun setCurrentPosition(position: Int){
        _currentPosition.value = position
    }

    fun getCurrentPosition() = currentPosition.value

}