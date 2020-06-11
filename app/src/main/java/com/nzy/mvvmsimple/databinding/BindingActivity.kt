package com.nzy.mvvmsimple.databinding

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nzy.mvvmsimple.R
import com.nzy.mvvmsimple.databinding.model.Cat
import kotlinx.android.synthetic.main.activity_binddata.*

/**
 *  @author niezhiyang
 *  since 2020/6/8
 */
class BindingActivity : AppCompatActivity() {
    private val viewModel: DataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityBinddataBinding =
            DataBindingUtil.setContentView<ActivityBinddataBinding>(
                this,
                R.layout.activity_binddata
            )

        viewModel.nameLiveData.value = "小小橘猫"
        viewModel.isBigPadding.value = true
        viewModel.drawable.value = resources.getDrawable(R.drawable.hashiqi_one)
        viewModel.padding.value = 20



        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        var cat = Cat()
        cat.name.set("咖啡猫")
        cat.isShowName.set(true)
        binding.cat = cat


        bt_change.setOnClickListener {
            viewModel.nameLiveData.value = "大大黄猫"
            cat.name.set("ObservableField 改变的咖啡猫")
            cat.isShowName.set(!cat.isShowName.get())

            var value: Boolean? = viewModel.isBigPadding.value
            if (value != null) {
                viewModel.isBigPadding.value = !value
            }
            viewModel.drawable.value = resources.getDrawable(R.drawable.hashiqi_two)
            if(viewModel.padding.value==20){
                viewModel.padding.value = 50

               Log.e("wwww" ,"${tv_padding.paddingTop}")
            }else{
                viewModel.padding.value = 20
                Log.e("wwww" ,"${tv_padding.paddingTop}")
            }


        }


        viewModel.observableFieldClick.set(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@BindingActivity, "绑定方式7", Toast.LENGTH_SHORT).show()
            }
        })
        binding.click = View.OnClickListener {
            Toast.makeText(this, "绑定方式1", Toast.LENGTH_SHORT).show()

        }

    }

    companion object {
        fun startMe(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, BindingActivity::class.java))
        }
    }
}