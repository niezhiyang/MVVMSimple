package com.nzy.mvvmsimple.livedatabus

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.lifecycleowner.LifeDemoActivity
import kotlinx.android.synthetic.main.activity_bus_demo2.*

/**
 *  @author niezhiyang
 *  since 2020/6/5
 */
class BusDemo2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_demo2)
        Log.e("sssss","aaaaa")
        LiveDataBus.instance.getObservable("key").value = "改变1"
        bt_start_two.setOnClickListener{
            LiveDataBus.instance.getObservable("key").value = "改变2"
        }


    }
    companion object {
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, BusDemo2Activity::class.java))
        }
    }
}