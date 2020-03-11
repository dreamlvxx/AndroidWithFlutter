package com.dream.android2flutter.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.ui.base
 * @ClassName:      BaseActivity
 * @Description:    主要处理基类页面相关的base东西
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/11 10:54 AM
 * @UpdateUser:     BaseActivity
 * @UpdateDate:     2020/3/11 10:54 AM
 */
abstract class BaseActivity<M : ViewModel, D : ViewDataBinding> : BaseComponentActivity<M, D>() {

    protected abstract fun initView()

    override fun childInit() {
        initView()
    }
}