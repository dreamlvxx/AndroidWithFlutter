package com.dream.android2flutter.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.dream.android2flutter.viewmodel.MainModel

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.utils
 * @ClassName:      ViewModelProviderUtils
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/11 1:04 PM
 * @UpdateUser:     ViewModelProviderUtils
 * @UpdateDate:     2020/3/11 1:04 PM
 */
class ViewModelProviderUtils {
    companion object{
         fun <T : ViewModel> createModel(owner : ViewModelStoreOwner,clazz : Class<T>) : T{
            return ViewModelProvider(owner,
                ViewModelProvider.AndroidViewModelFactory.getInstance(ApplicationUtils.getApplicationContext()))
                .get(clazz)
        }
    }
}