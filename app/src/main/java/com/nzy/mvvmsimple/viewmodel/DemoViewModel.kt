package com.nzy.mvvmsimple.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.nzy.mvvmsimple.user.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 *  @author niezhiyang
 *  since 2020/5/23
 */
class DemoViewModel : ViewModel() {
    var dis :Disposable?=null
     val dataLive: MutableLiveData<String> by lazy {
         MutableLiveData<String>()
     }



    fun getName(){
        viewModelScope.launch {
            delay(1000)
            dataLive.value = "王者荣耀"

          dis =   Observable.interval(1000,TimeUnit.MILLISECONDS).subscribe{
                Log.e("sssssss","$it")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        dis?.dispose()
    }
}