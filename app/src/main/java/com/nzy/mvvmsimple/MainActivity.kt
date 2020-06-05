package com.nzy.mvvmsimple

import android.app.ProgressDialog
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nzy.mvvmsimple.databinding.ActivityMainBinding
import com.nzy.mvvmsimple.lifecycleowner.LifeDemoActivity
import com.nzy.mvvmsimple.livedatabus.BusDemo1Activity
import com.nzy.mvvmsimple.livedatademo.LiveDataActivity
import com.nzy.mvvmsimple.livepermission.PermissionActivity
import com.nzy.mvvmsimple.user.UserActivity
import com.nzy.mvvmsimple.viewmodel.ViewModelDemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        bt_simple.setOnClickListener {
            UserActivity.startMe(this)
        }

        bt_viewmodel_simple.setOnClickListener {
            ViewModelDemoActivity.startMe(this)
        }
        bt_lifeOwner_simple.setOnClickListener {
            LifeDemoActivity.startMe(this)
        }

        bt_livedata_simple.setOnClickListener {
            LiveDataActivity.startMe(this)
        }
        bt_bus_simple.setOnClickListener {
            BusDemo1Activity.startMe(this)
        }
        bt_permission_simple.setOnClickListener {
            PermissionActivity.startMe(this)
        }
//        val uri: Uri = Uri.parse("content://com.example.ticker.bookprovider.BooksProvider")
//        contentResolver.query(uri, null, null, null, null)
    }
}
