package com.nzy.mvvmsimple.livepermission

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData

/**
 *  @author niezhiyang
 *  since 2020/6/5
 */
class LivePermission {
    private var activity: AppCompatActivity? = null
    private var fragment: Fragment? = null
    private val liveData by lazy {
        MutableLiveData<Boolean>()

    }
    private val permissionFragment: PermissionFragment by lazy {
        PermissionFragment()
    }

    constructor(activity: AppCompatActivity) {
        this.activity = activity
    }

    constructor(fragment: Fragment) {
        this.fragment = fragment
    }

    fun request(permission: String): MutableLiveData<Boolean> {
        var fragmentManager: FragmentManager? = null
        if (activity != null) {
            fragmentManager = activity!!.supportFragmentManager
        } else if (fragment != null) {
            fragmentManager = fragment!!.childFragmentManager
        }
        fragmentManager?.beginTransaction()?.add(permissionFragment, TAG)?.commitNow()
        permissionFragment.request(liveData,permission)
        return liveData
    }

    companion object {
        val TAG = "LivePermission"
    }
}


