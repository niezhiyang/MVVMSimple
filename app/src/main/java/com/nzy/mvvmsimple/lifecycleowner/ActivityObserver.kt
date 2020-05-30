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
class ActivityObserver : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e(LifeDemoActivity.TAG,"LifecycleObserver --onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e(LifeDemoActivity.TAG,"LifecycleObserver --onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e(LifeDemoActivity.TAG,"LifecycleObserver --onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e(LifeDemoActivity.TAG,"LifecycleObserver --onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e(LifeDemoActivity.TAG,"LifecycleObserver --onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e(LifeDemoActivity.TAG,"LifecycleObserver --onDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
    }

}