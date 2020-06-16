package com.nzy.mvvmsimple.databinding.adapter

import android.view.View
import androidx.databinding.BindingAdapter

/**
 *  @author niezhiyang
 *  since 2020/6/15
 */
@BindingAdapter("isGone")
fun setIsGone(view: View, isGone: Boolean?) {
    if (isGone != null) {
        view.visibility = if (isGone) View.GONE else View.VISIBLE
    }
}