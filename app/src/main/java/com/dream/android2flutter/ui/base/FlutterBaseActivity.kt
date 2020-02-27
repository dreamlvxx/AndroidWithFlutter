package com.dream.android2flutter.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.flutter.app.FlutterFragmentActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.view.FlutterView


/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter
 * @ClassName:      FlutterBaseActivity
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/2/25 5:23 PM
 * @UpdateUser:     FlutterBaseActivity
 * @UpdateDate:     2020/2/25 5:23 PM
 */
class FlutterBaseActivity : FlutterFragmentActivity() {
    val CHANNEL = "sample.flutter.io/test"

    companion object {
        fun startCurrentActivity(context: Context, initRoute: String) {
            //配置启动Intent
            val intent = Intent(context, FlutterBaseActivity::class.java)
            intent.action = "android.intent.action.RUN"//这个就是走flutter的关键
            intent.putExtra("route", initRoute)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerMethod()
    }

    private fun registerMethod(){
        MethodChannel(
            flutterView as FlutterView,
            CHANNEL
        ).setMethodCallHandler { methodCall, result ->
            if (methodCall.method == "getAcivityResult") {
                result.success("success lvxingxing") //回调给flutter的参数
            }
        }
    }

    override fun onBackPressed() {
        if(this.flutterView!=null){
            this.flutterView.popRoute();
            super.onBackPressed();
        }else {
            super.onBackPressed();
        }
    }

}