package com.dream.android2flutter

import android.app.Application
import android.content.Context
import com.dream.android2flutter.utils.ApplicationUtils

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter
 * @ClassName:      AppApplication
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/11 1:33 PM
 * @UpdateUser:     AppApplication
 * @UpdateDate:     2020/3/11 1:33 PM
 */

class AppApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        ApplicationUtils.attchApplicationContext(this)
    }

}