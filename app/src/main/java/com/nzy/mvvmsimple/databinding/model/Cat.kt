package com.nzy.mvvmsimple.databinding.model

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

/**
 *  @author niezhiyang
 *  since 2020/6/8
 */
class Cat {
    var name: ObservableField<String> = ObservableField<String>()
    var isShowName = ObservableBoolean()
}