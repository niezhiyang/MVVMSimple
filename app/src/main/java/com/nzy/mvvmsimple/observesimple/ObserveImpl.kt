package com.nzy.mvvmsimple.observesimple

import android.util.Log

/**
 *  @author niezhiyang
 *  since 2020/5/30
 */
class ObserveImpl(var name:String):Observe {
    override fun received(message: String) {
        System.out.println("${name}---${message}")
    }
}