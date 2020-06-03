package com.nzy.mvvmsimple.livedatademo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ActivityLivedataBinding
import com.nzy.mvvmsimple.databinding.ActivityUserBinding
import com.nzy.mvvmsimple.lifecycleowner.LifeDemoActivity
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
        })

    }

    companion object {
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, LiveDataActivity::class.java))
        }
    }
}