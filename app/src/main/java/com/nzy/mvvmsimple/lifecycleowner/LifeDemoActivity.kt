package com.nzy.mvvmsimple.lifecycleowner

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.viewmodel.ViewModelDemoActivity
import org.jetbrains.annotations.NotNull


class LifeDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG, "onCreate --之前")
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate --之后")
        setContentView(R.layout.activity_life_demo)
        getLifecycle().addObserver(ActivityObserver())
    }

    override fun onStart() {
        Log.e(TAG, "onStart --之前")
        super.onStart()
        Log.e(TAG, "onStart --之后")
    }

    override fun onRestart() {
        Log.e(TAG, "onRestart --之前")
        super.onRestart()
        Log.e(TAG, "onRestart --之后")
    }

    override fun onResume() {
        Log.e(TAG, "onResume --之前")
        super.onResume()
        Log.e(TAG, "onResume --之后")
    }

    override fun onPause() {
        Log.e(TAG, "onPause --之前")
        super.onPause()
        Log.e(TAG, "onPause --之后")
    }

    override fun onStop() {
        Log.e(TAG, "onStop --之前")
        super.onStop()
        Log.e(TAG, "onStop --之后")
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy --之前")
        super.onDestroy()
        Log.e(TAG, "onDestroy --之后")
    }

    companion object {
         val TAG = "LifeDemoActivity";
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, LifeDemoActivity::class.java))
        }
    }
}
