package com.nzy.mvvmsimple.user

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 *  @author niezhiyang
 *  since 2020/5/18
 *  用户的ViewModel
 */
class UserViewModel(private val repository: UserRepository) : ViewModel() {
    var userData = MutableLiveData<User>()
    var progressShow = MutableLiveData<Boolean>()

    fun click(view: View) {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            progressShow.value = true
            userData.value = repository.getUser()
            progressShow.value = false

        }
    }
}