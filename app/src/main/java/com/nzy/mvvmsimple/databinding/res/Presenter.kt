package com.nzy.mvvmsimple.databinding.res

import android.app.Application
import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.nzy.mvvmsimple.MyApplication

/**
 *  @author niezhiyang
 *  since 2020/6/16
 */
class Presenter : BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        Toast.makeText(MyApplication.application,"$position",Toast.LENGTH_SHORT).show()
        onItemClick()
    }
     fun onItemClick() {
        Toast.makeText(MyApplication.application,"LALLALA",Toast.LENGTH_SHORT).show()
    }

    override fun onLoadMoreRequested() {
        Toast.makeText(MyApplication.application,"加载了",Toast.LENGTH_SHORT).show()
    }
}