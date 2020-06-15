package com.nzy.mvvmsimple.databinding.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *  @author niezhiyang
 *  since 2020/6/12
 */




@BindingAdapter(value = ["imageUrl", "placeholder", "error"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?, placeHolder: Drawable?, error: Drawable?) {
    if (url == null) {
        imageView.setImageDrawable(placeHolder);
    } else {
        Glide.with(imageView).load(url).placeholder(placeHolder).error(error).into(imageView)
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

