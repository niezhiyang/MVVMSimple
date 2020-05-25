package com.nzy.mvvmsimple.viewmodel

import androidx.lifecycle.*
import com.nzy.mvvmsimple.user.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *  @author niezhiyang
 *  since 2020/5/23
 */
class DemoViewModel : ViewModel() {
     val dataLive: MutableLiveData<String> =
         MutableLiveData<String>()


    fun getName(){
        viewModelScope.launch {
            delay(1000)
            dataLive.value = "王者荣耀"
        }
    }
}