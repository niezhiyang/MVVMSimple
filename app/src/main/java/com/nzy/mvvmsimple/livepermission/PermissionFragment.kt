package com.nzy.mvvmsimple.livepermission

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData

/**
 *  @author niezhiyang
 *  since 2020/6/5
 */
class PermissionFragment : Fragment() {
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var permission: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun request(liveData: MutableLiveData<Boolean>, permission: String) {
        this.permission = permission
        this.liveData = liveData;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(requireContext(),permission) == PackageManager.PERMISSION_GRANTED) {
                liveData.value = true
            } else {
                var arrayPermissons = arrayOf(permission)
                requestPermissions(arrayPermissons, REQUEST_PERMISSION_CODE);
            }
        } else {
            liveData.value = true
        }
    }

    companion object {
        private const val REQUEST_PERMISSION_CODE = 10000
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (permission == permissions[0] && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                liveData.value = true
            } else {
                liveData.value = false
            }

        }
    }
}