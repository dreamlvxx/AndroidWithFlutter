package com.dream.android2flutter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.viewmodel
 * @ClassName:      MainModel
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/10 2:05 PM
 * @UpdateUser:     MainModel
 * @UpdateDate:     2020/3/10 2:05 PM
 */
class MainModel : ViewModel() {
    var msg: MutableLiveData<String> = MutableLiveData()
}