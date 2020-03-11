package com.dream.android2flutter.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.ui.base
 * @ClassName:      BaseComponentActivity
 * @Description:    主要处理AAC的东西
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/11 10:30 AM
 * @UpdateUser:     BaseComponentActivity
 * @UpdateDate:     2020/3/11 10:30 AM
 */
abstract class BaseComponentActivity<M : ViewModel, D : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: D
    protected lateinit var model: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewDataBinding()
        model = setViewModel()
        binding.lifecycleOwner = this
        childInit()
    }

    private fun initViewDataBinding(){
        binding = DataBindingUtil.setContentView<D>(this, getLayoutId())
    }

    protected abstract fun getLayoutId(): Int

    abstract fun setViewModel() : M

    fun getViewModel() : M?{
        return model
    }

    fun getViewDataBinding() : D?{
        return binding
    }

    abstract fun childInit()

}