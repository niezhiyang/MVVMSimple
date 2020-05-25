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
        viewModel.dataLive.observe(viewLifecycleOwner, Observer {
            tv_name_one.text = it
        })

        tv_one.setOnClickListener {
            viewModel.dataLive.value = "Fragment-One，改变的值"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShareOneFragment()
    }
}
