package com.nzy.mvvmsimple

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.nzy.mvvmsimple.lifecycleowner.ActivityObserver
import com.nzy.mvvmsimple.lifecycleowner.ApplicationObserver
import com.nzy.mvvmsimple.lifecycleowner.LifeDemoActivity


/**
 *  @author niezhiyang
 *  since 2020/5/28
 */
 class MyApplication : Application() {



    companion object{
        @JvmStatic lateinit var application: MyApplication
    }
    override fun onCreate() {
        super.onCreate()
        application = this
//        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivityPaused")
                }
            }

            override fun onActivityResumed(activity: Activity?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivityResumed")
                }

            }

            override fun onActivityStarted(activity: Activity?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivityStarted")
                }

            }

            override fun onActivityDestroyed(activity: Activity?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivityDestroyed")
                }

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivitySaveInstanceState")
                }

            }

            override fun onActivityStopped(activity: Activity?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivityStopped")
                }

            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                if (activity is LifeDemoActivity) {
                    Log.e(LifeDemoActivity.TAG, "Application --onActivityCreated")
                }

            }

        });
    }
}