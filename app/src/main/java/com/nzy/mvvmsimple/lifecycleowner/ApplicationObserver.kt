package com.nzy.mvvmsimple.lifecycleowner

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 *  @author niezhiyang
 *  since 2020/5/28
 */
class ApplicationObserver : LifecycleObserver {


    /**
     * 在app中只调用一次，当在第一个页面按返回键的时候，此时进程没有被杀死，此时再打开app，也是不会走此方法
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e(LifeDemoActivity.TAG,"ApplicationObserver --onCreate")
    }
    /**
     * 应用在前台 对于Application onStart和onResume 都是成对出现的
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e(LifeDemoActivity.TAG,"ApplicationObserver --onStart")
    }

    /**
     * 应用在前台
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e(LifeDemoActivity.TAG,"ApplicationObserver --onResume")
    }

    /**
     * 应用在后台 对于Application onPause和ON_STOP 都是成对出现的
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e(LifeDemoActivity.TAG,"ApplicationObserver --onPause")
    }

    /**
     * 应用在后台
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e(LifeDemoActivity.TAG,"ApplicationObserver --onStop")
    }

    /**
     * 这里永远也走不到
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e(LifeDemoActivity.TAG,"ApplicationObserver --onDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
    }

}