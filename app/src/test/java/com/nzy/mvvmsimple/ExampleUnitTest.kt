package com.nzy.mvvmsimple

import com.google.gson.Gson
import com.nzy.mvvmsimple.bean.Bean
import com.nzy.mvvmsimple.observesimple.Observable
import com.nzy.mvvmsimple.observesimple.ObservableImpl
import com.nzy.mvvmsimple.observesimple.Observe
import com.nzy.mvvmsimple.observesimple.ObserveImpl
import org.junit.Test
import java.util.*

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


    @Test
    fun testGson() {
        // 虽然 gson 解析data的时候会绕过 kotlin 的非空 判断
        var gson = Gson()
        var text = "{\"age\":\"302\",\"name\":\"100元1000爱心\"}"

        var text2 = "{\"name\":\"100元1000爱心\"}"
        var text3 = "{\"age\":\"302\"}"
        var bean = gson.fromJson(text, Bean::class.java)
        var bean2 = gson.fromJson<Bean>(text2, Bean::class.java)
        var bean3 = gson.fromJson<Bean>(text3, Bean::class.java)
        println(bean)
        println(bean2)
        println(bean3)


    }

    @Test
    fun testUUID() {
        val own: String = UUID.randomUUID().toString()
        //31bc7a2d-b344-4d19-a65e-c0756b9d6b79
        println(own)


    }
}
