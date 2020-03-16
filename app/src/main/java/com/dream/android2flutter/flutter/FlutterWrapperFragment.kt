package com.dream.android2flutter.flutter

import androidx.fragment.app.Fragment
import io.flutter.embedding.android.FlutterFragment

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.flutter
 * @ClassName:      FlutterWrapperFragment
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/16 5:57 PM
 * @UpdateUser:     FlutterWrapperFragment
 * @UpdateDate:     2020/3/16 5:57 PM
 */
class FlutterWrapperFragment{
    companion object{
        fun getFragment() : FlutterFragment{
            val flutterFragment = FlutterFragment.withNewEngine()
                .initialRoute("myInitialRoute/")
                .build<FlutterFragment>()
            return flutterFragment
        }
    }
}