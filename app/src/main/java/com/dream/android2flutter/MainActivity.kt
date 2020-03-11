package com.dream.android2flutter

import com.dream.android2flutter.databinding.ActivityMainBinding
import com.dream.android2flutter.ui.base.BaseActivity
import com.dream.android2flutter.utils.ViewModelProviderUtils
import com.dream.android2flutter.viewmodel.MainModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainModel,ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun setViewModel(): MainModel {
        val model = ViewModelProviderUtils.createModel(this,MainModel::class.java)
        binding.mainModel = model
        return model
    }

    override fun initView() {
        model.msg.value = "initValue"
        tv_btn.setOnClickListener {
            model.msg.postValue("newValue")
        }
    }


}
