package com.nzy.mvvmsimple.observesimple

/**
 *  @author niezhiyang
 *  since 2020/5/30
 */
interface Observable {

    /**
     * 添加观察者
     */
    fun addObserver(observe:Observe)

    /**
     * 移除观察者
     */
    fun removeObserver(observe:Observe)

    /**
     * 通知观察者
     */
    fun notifyObserve()
}
