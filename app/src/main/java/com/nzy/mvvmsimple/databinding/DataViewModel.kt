package com.nzy.mvvmsimple.databinding

import android.app.Application
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *  @author niezhiyang
 *  since 2020/6/8
 */
class DataViewModel(context: Application) : AndroidViewModel(context) {
    var nameLiveData = MutableLiveData<String>()
    var imageUrl = MutableLiveData<String>()
    var isBigPadding = MutableLiveData<Boolean>()
    var drawable = MutableLiveData<Drawable>()
    var padding = MutableLiveData<Int>()

    /**
     * 无参数的点击
     */
    fun click() {
        Toast.makeText(getApplication(), "绑定方式2", Toast.LENGTH_SHORT).show()
    }

    /**
     * 拿到自己View
     */
    fun click(view: View) {
        Toast.makeText(getApplication(), "绑定方式3", Toast.LENGTH_SHORT).show()
    }

    /**
     * 带参数
     */
    fun click(name:String){
        Toast.makeText(getApplication(), "绑定方式4$name", Toast.LENGTH_SHORT).show()
    }


    /**
     * 带参数并且拿到View
     */
    fun click(view:View,name:String){
        Toast.makeText(getApplication(), "绑定方式5$name", Toast.LENGTH_SHORT).show()
    }

    /**
     * 通过 ObservableField 包裹的click 不带参数
     */

    var observableFieldClick = ObservableField<View.OnClickListener>()

}