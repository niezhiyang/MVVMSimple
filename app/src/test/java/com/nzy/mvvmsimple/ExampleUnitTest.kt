package com.nzy.mvvmsimple

import com.nzy.mvvmsimple.observesimple.Observable
import com.nzy.mvvmsimple.observesimple.ObservableImpl
import com.nzy.mvvmsimple.observesimple.Observe
import com.nzy.mvvmsimple.observesimple.ObserveImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testObserve() {
        var observable: Observable = ObservableImpl()

        var observeZhang: Observe = ObserveImpl("张三")
        var observeLi: Observe = ObserveImpl("李四")
        var observeWang: Observe = ObserveImpl("王五")

        observable.addObserver(observeZhang)
        observable.addObserver(observeLi)
        observable.addObserver(observeWang)

        observable.notifyObserve()

        observable.removeObserver(observeZhang)

        println("")
        println("---去除张三----")
        println("")


        observable.notifyObserve()


    }
}
