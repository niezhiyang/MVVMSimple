package com.nzy.mvvmsimple.livedatabus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.ConcurrentHashMap

/**
 *  @author niezhiyang
 *  since 2020/6/5
 */
class LiveDataBus private constructor() {
    private val mapData by lazy { HashMap<String, MutableLiveData<Any>>() }

    // 用这个key 来决定分发和接受的
    fun getObservable(key: String): MutableLiveData<Any> {

        return getObservable(key,Any::class.java)
    }

    // 用这个key 来决定分发和接受的
    fun <T> getObservable(key: String, clazz: Class<T>): MutableLiveData<T> {

        if(!mapData.contains(key)){
            mapData[key] = MutableLiveData()
        }

        var liveData = mapData[key];


        return (liveData as MutableLiveData<T>)
    }

    companion object {
        val instance: LiveDataBus by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LiveDataBus()
        }
    }
}