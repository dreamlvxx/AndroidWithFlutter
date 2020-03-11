package com.dream.android2flutter.utils

import android.app.Application

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.utils
 * @ClassName:      ApplicationUtils
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/11 1:26 PM
 * @UpdateUser:     ApplicationUtils
 * @UpdateDate:     2020/3/11 1:26 PM
 */
class ApplicationUtils {
    companion object{
        lateinit var app : Application
        public fun attchApplicationContext(application : Application){
            app = application
        }

        public fun getApplicationContext() : Application{
            return app
        }
    }
}