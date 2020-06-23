package com.nzy.mvvmsimple.databinding.res

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.ItemUserBinding
import com.nzy.mvvmsimple.user.User
import java.text.FieldPosition

/**
 *  @author niezhiyang
 *  since 2020/6/16
 */
class DemoBindAdapter :
    BaseQuickAdapter<User, BaseDataBindingHolder<ItemUserBinding>>(R.layout.item_user) {
    override fun convert(helper: BaseDataBindingHolder<ItemUserBinding>?, item: User?) {
        helper?.run {
            dataBinding?.user = item
            dataBinding?.adapter = this@DemoBindAdapter
            dataBinding?.position = helper.adapterPosition - headerLayoutCount
            dataBinding?.executePendingBindings()
//            dataBinding?.position = helper.layoutPosition
//            dataBinding?.position = helper.oldPosition
        }
    }

    override fun onCreateDefViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): BaseDataBindingHolder<ItemUserBinding> {
        var binding = DataBindingUtil.inflate<ItemUserBinding>(
            LayoutInflater.from(parent?.context),
            mLayoutResId,
            parent,
            false
        )
        return BaseDataBindingHolder(binding.root)
    }

    fun itemChildClick(view: View, user: User, position: Int) {
//        Toast.makeText(mContext, "$position--" + user.name, Toast.LENGTH_SHORT).show()
    }

}