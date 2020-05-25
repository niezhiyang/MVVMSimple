package com.nzy.mvvmsimple.viewmodel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ActivityUserBinding
import com.nzy.mvvmsimple.databinding.ActivityViewmodelDemoBinding
import com.nzy.mvvmsimple.user.User
import com.nzy.mvvmsimple.user.UserActivity
import com.nzy.mvvmsimple.user.UserViewModel
import kotlinx.android.synthetic.main.activity_viewmodel_demo.*

/**
 *  @author niezhiyang
 *  since 2020/5/23
 */
class ViewModelDemoActivity : AppCompatActivity() {
    private val viewModel: DemoViewModel by lazy { ViewModelProvider(this).get(DemoViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       var binding = DataBindingUtil.setContentView<ActivityViewmodelDemoBinding>(
            this,
            R.layout.activity_viewmodel_demo
        )
        viewModel.dataLive.observe(this, object : Observer<String> {
            override fun onChanged(s: String?) {
                // 当横竖屏变换时，会重新走这里，毕竟是View也都重新绘制了，只不过user里面立马有值
                tv_name.text = s
            }
        })

        tv_name.setOnClickListener{
            viewModel.dataLive.value= "Activity触发的改变"
        }
        viewModel.getName()
    }
    companion object {
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, ViewModelDemoActivity::class.java))
        }
    }
}