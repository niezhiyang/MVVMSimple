package com.nzy.mvvmsimple.livepermission

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.livedatademo.LiveDataActivity
import kotlinx.android.synthetic.main.activity_permission.*

/**
 *  @author niezhiyang
 *  since 2020/6/5
 */
class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        bt_requst.setOnClickListener {


            LivePermission(this).request(Manifest.permission.READ_EXTERNAL_STORAGE).observe(this,
                Observer {
                    Toast.makeText(this@PermissionActivity, "$it", Toast.LENGTH_SHORT).show()
                })
        }



    }

    companion object {
        val TAG = "PermissionActivity"
        fun startMe(activity: Activity) {
            activity.startActivity(Intent(activity, PermissionActivity::class.java))
        }
    }
}