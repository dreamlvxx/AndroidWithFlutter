package com.dream.android2flutter.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterSurfaceView
import io.flutter.plugin.common.MethodChannel

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
class FlutterBaseActivity : FlutterActivity() {
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

    override fun onFlutterSurfaceViewCreated(flutterSurfaceView: FlutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView)
        registerMethod();
    }

    private fun registerMethod() {
        MethodChannel(
            flutterEngine?.dartExecutor,
            CHANNEL
        ).setMethodCallHandler { methodCall, result ->
            if (methodCall.method == "getAcivityResult") {
                result.success("success wocao le ") //回调给flutter的参数
            }
        }
    }

}