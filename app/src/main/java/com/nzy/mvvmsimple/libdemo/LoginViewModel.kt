package com.nzy.mvvmsimple.libdemo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nzy.library.base.BaseViewModel

/**
 *  @author niezhiyang
 *  since 2020/6/22
 */
class LoginViewModel : BaseViewModel() {
    var isShowName = MutableLiveData<Boolean>()

}