package com.nzy.mvvmsimple.databinding.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 *  @author niezhiyang
 *  since 2020/6/17
 */
@BindingAdapter(value = ["itemClickListener", "loadMoreListener"], requireAll = false)
fun setRecyclerView(
    recyclerView: RecyclerView,
    itemClickListener: BaseQuickAdapter.OnItemClickListener?,
    loadMoreListener: BaseQuickAdapter.RequestLoadMoreListener?
) {

    var adapter = recyclerView.adapter as BaseQuickAdapter<*, *>
    if (itemClickListener != null) {
        adapter.onItemClickListener = itemClickListener
    }

    if (loadMoreListener != null) {
        adapter.setOnLoadMoreListener(loadMoreListener, recyclerView)
    }
}