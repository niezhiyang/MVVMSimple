package com.nzy.mvvmsimple.livedatabus

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nzy.mvvmsimple.R
import kotlinx.android.synthetic.main.activity_bus_demo.*

/**
 *  @author niezhiyang
 *  since 2020/6/5
 */
class BusDemo1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_demo)
        bt_start_two.setOnClickListener {
            BusDemo2Activity.startMe(this)
        }

        LiveDataBus.instance.getObservable("key", String::class.java)
            .observe(this, object : Observer<String> {
                override fun onChanged(t: String?) {
                    Toast.makeText(this@BusDemo1Activity, t, Toast.LENGTH_SHORT).show()
                    bt_start_two.text = t
                    Log.e("sssss","dddddd")
                }
            })

    }

    override fun onPause() {
        super.onPause()
        Log.e("sssss","kkkkkkkkkk")
    }

    override fun onStop() {
        super.onStop()
        Log.e("sssss","stop")
    }
    companion object {
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, BusDemo1Activity::class.java))
        }
    }
}