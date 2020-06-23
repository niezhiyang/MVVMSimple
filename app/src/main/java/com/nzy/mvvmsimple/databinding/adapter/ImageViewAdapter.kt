package com.nzy.mvvmsimple.databinding.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *  @author niezhiyang
 *  since 2020/6/12
 */


@BindingAdapter(value = ["imageUrl", "placeholderRes", "errorRes"], requireAll = false)
fun bindImageUrl(imageView: ImageView, url: String?, placeholderRes: Int?, errorRes: Int?) {
    if (url.isNullOrEmpty() && placeholderRes != null) {
        imageView.setImageResource(placeholderRes);
    } else {
        var glide = Glide.with(imageView).load(url);
        if (placeholderRes != null) {
            glide = glide.placeholder(placeholderRes)
        }

        if (errorRes != null) {
            glide = glide.error(errorRes)
        }

        glide.into(imageView)
    }
}



