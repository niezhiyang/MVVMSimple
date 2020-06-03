package com.nzy.mvvmsimple.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nzy.mvvmsimple.viewmodel.DemoViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *  @author niezhiyang
 *  since 2020/6/3
 */
class TimeViewModel:ViewModel() {
    var time = 0
     val timeMutableLiveData: MutableLiveData<Int> =
        MutableLiveData<Int>()
    init {
        getTime()
    }
    private fun getTime(){
        viewModelScope.launch {
            delay(1000)
            timeMutableLiveData.value = ++time
            getTime()
        }
    }
}