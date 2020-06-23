package com.nzy.mvvmsimple.libdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nzy.library.base.BaseActivity
import com.nzy.library.model.ActivityModel
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ActivityLibBinding
import com.nzy.mvvmsimple.user.UserActivity
import kotlinx.android.synthetic.main.activity_lib.*

/**
 *  @author niezhiyang
 *  since 2020/6/22
 */
class LoginActivity : BaseActivity<ActivityLibBinding, LoginViewModel>() {

//    override fun initViewModel(): LoginViewModel {
//        return ViewModelProvider(this).get(LoginViewModel::class.java)
//    }


    companion object {
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

    override fun setContentViewId(): Int {
        return R.layout.activity_lib
    }

}