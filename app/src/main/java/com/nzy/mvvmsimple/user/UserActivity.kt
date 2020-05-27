package com.nzy.mvvmsimple.user

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ActivityUserBinding
import com.nzy.mvvmsimple.injector.InjectorUtils

/**
 * 简单的MVVM实现页面
 */
class UserActivity : AppCompatActivity() {
    //创建ViewModel方式1
//   private val viewModel: UserViewModel by viewModels()
    //创建ViewModel方式2
//    private val viewModel:UserViewModel by lazy { ViewModelProvider(this,InjectorUtils.provideUserViewModelFactory()).get(UserViewModel::class.java) }


    private val viewModel: UserViewModel by viewModels {
        // 通过InjectorUtils类拿到对应的ViewModelFactory，这种方法可以定义构造方法带参的ViewModel
        InjectorUtils.provideUserViewModelFactory()
    }
    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding =
            DataBindingUtil.setContentView<ActivityUserBinding>(this, R.layout.activity_user)
        //绑定生命周期，声明这个 Activity 为 Data Binding 的 lifecycleOwner
        binding.lifecycleOwner = this
        //设置xml中的viewModel
        binding.viewmodel = viewModel
        // viewModel的progressShow 来判断是否是加载中的状态
        viewModel.progressShow.observe(this, Observer<Boolean> {
            if (it) showLoading()
            else stopLoading()
        })
    }

    /**
     * 显示加载框
     */
    private fun showLoading() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog!!.setMessage("加载中")
        }
        progressDialog!!.show()
    }

    /**
     * 关闭加载框
     */
    private fun stopLoading() {
        progressDialog?.dismiss()
    }


    companion object {
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, UserActivity::class.java))
        }
    }



}
