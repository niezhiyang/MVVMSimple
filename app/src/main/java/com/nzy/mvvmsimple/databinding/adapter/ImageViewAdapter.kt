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
fun setImageUrl(imageView: ImageView, url: String?, placeholderRes: Int?, errorRes: Int?) {
    if (url == null && placeholderRes != null) {
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


/**
 * 如果 value的名字一样 会优先走上面的那个
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    if (url != null) {
        Glide.with(imageView).load(url).into(imageView)
    }
}

