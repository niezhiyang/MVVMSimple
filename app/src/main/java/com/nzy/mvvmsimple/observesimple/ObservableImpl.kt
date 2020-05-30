package com.nzy.mvvmsimple.observesimple

/**
 *  @author niezhiyang
 *  since 2020/5/30
 */
class ObservableImpl : Observable {

    private val arrayList = ArrayList<Observe>()

    override fun addObserver(observe: Observe) {
        if (!arrayList.contains(observe)) {
            arrayList.add(observe)
        }

    }

    override fun removeObserver(observe: Observe) {
        arrayList.remove(observe)
    }

    override fun notifyObserve() {
        for (observe in arrayList) {
            observe.received("收到信息了")
        }
    }
}