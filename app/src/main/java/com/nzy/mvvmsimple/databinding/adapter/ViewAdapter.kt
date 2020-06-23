package com.nzy.mvvmsimple.databinding.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.nzy.mvvmsimple.databinding.command.BindingCommand
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.functions.Consumer
import java.util.concurrent.TimeUnit

/**
 *  @author niezhiyang
 *  since 2020/6/15
 */
@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean?) {
    if (isGone != null) {
        view.visibility = if (isGone) View.GONE else View.VISIBLE
    }
}


@BindingAdapter("singleClick")
fun bindSingleClick(view: View, singleClick: BindingCommand?) {
    var emitter: ObservableEmitter<Any>? = null
    Observable.create(ObservableOnSubscribe<Any> { emitterr -> emitter = emitterr })
        .throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe { singleClick?.execute() }

    view.setOnClickListener {
        emitter?.onNext("")
    }
}