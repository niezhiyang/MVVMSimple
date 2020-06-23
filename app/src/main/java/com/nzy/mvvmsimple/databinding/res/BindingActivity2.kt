package com.nzy.mvvmsimple.databinding.res

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.nzy.library.utils.showToast
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ActivityBinding2Binding
import com.nzy.mvvmsimple.databinding.BindingActivity
import com.nzy.mvvmsimple.databinding.command.BindingAction
import com.nzy.mvvmsimple.databinding.command.BindingCommand
import com.nzy.mvvmsimple.user.User
import kotlinx.android.synthetic.main.activity_binding2.*

class BindingActivity2 : AppCompatActivity() {

    val viewModel: NameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityBinding2Binding>(
            this, R.layout.activity_binding2
        )

        var command = BindingCommand(object : BindingAction {
            override fun call() {
                showToast("lalala");
                Log.e("ssssss", "kalallalal");
            }
        })
        binding.command = command
        binding.adapter = viewModel.adapter
        var presenter = Presenter()
        var userList = ArrayList<User>()
        for (i in 1..20) {
            var user = User("名字$i $i", 18)
            userList.add(user)
        }
        //        adapter.setNewData(userList)
        var textView = TextView(this)
        textView.text = " 偷不偷不偷不"
        //        adapter.addHeaderView(textView)
    }

    companion object {
        fun startMe(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, BindingActivity2::class.java))
        }
    }
}