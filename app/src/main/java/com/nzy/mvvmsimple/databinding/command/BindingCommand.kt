package com.nzy.mvvmsimple.databinding.command
import android.view.View

/**
 *  @author niezhiyang
 *  since 2020/6/18
 */
open class BindingCommand constructor(var execute: BindingAction?) {

    fun execute() {
        execute?.call()
    }

}