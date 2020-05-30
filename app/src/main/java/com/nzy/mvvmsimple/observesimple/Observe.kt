package com.nzy.mvvmsimple.observesimple

/**
 *  @author niezhiyang
 *  since 2020/5/30
 */
interface Observe {
    // 收到消息之后的数据
    fun received(message:String)
}