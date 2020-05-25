package com.nzy.mvvmsimple.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.nzy.mvvmsimple.R
import kotlinx.android.synthetic.main.fragment_share_one.*
import kotlinx.android.synthetic.main.fragment_share_two.*

class ShareOneFragment : Fragment() {
    // 创建以Activity为维度的ViewModel，注意 这里是 requireActivity() 不是 getActivity(),requireActivity()不可能为空，getActivity()有可能为空
    private val viewModel: DemoViewModel
            by lazy { ViewModelProvider(requireActivity()).get(DemoViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_share_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // 这里传入是 viewLifecycleOwner（getViewLifecycleOwner()）,而不会Fragment本身
        viewModel.dataLive.observe(viewLifecycleOwner, Observer {
            tv_name_one.text = it
        })

        // 在 FragmentOne 中去改变值
        tv_one.setOnClickListener {
            viewModel.dataLive.value = "Fragment-One，改变的值"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ShareOneFragment()
    }
}
