package com.nzy.mvvmsimple

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.nzy.mvvmsimple.databinding.ActivityMainBinding
import com.nzy.mvvmsimple.injector.InjectorUtils
import com.nzy.mvvmsimple.user.UserActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        bt_simple.setOnClickListener {

            UserActivity.startMe(this)
        }
    }
}
