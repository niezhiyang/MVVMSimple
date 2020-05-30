package com.nzy.mvvmsimple.observesimple

/**
 *  @author niezhiyang
 *  since 2020/5/30
 */
interface Observable {
    fun addObserver(observe:Observe)
    fun removeObserver(observe:Observe)
    fun notifyObserve()
}
