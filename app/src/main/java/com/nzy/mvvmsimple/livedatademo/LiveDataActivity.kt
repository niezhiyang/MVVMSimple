package com.nzy.mvvmsimple.livedatademo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ActivityLivedataBinding
import com.nzy.mvvmsimple.databinding.ActivityUserBinding
import com.nzy.mvvmsimple.lifecycleowner.LifeDemoActivity
import com.nzy.mvvmsimple.livedatabus.BusDemo1Activity
import com.nzy.mvvmsimple.livedatabus.BusDemo2Activity
import kotlinx.android.synthetic.main.activity_livedata.*

/**
 *  @author niezhiyang
 *  since 2020/6/3
 */
class LiveDataActivity : AppCompatActivity() {

    private val viewModel: TimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityLivedataBinding>(
            this,
            R.layout.activity_livedata
        )
        viewModel.timeMutableLiveData.observe(this, Observer {
            tv_time.text = "${it}秒"
            Log.e(TAG,"${it}秒");

        })
        tv_time.setOnClickListener{
            // 我打开的这个Activity是透明的，所以 LiveDataActivity 的onStop方法不会执行
            BusDemo1Activity.startMe(this)
        }
//        viewModel.timeMutableLiveData.observeForever {
//        Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
//        }


    }


    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop");
    }

    companion object {
        val TAG = "LiveDataActivity"
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, LiveDataActivity::class.java))
        }
    }


}