package com.dream.android2flutter.flutter

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter
 * @ClassName:      FlutterWrapperActivity
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/2/25 5:23 PM
 * @UpdateUser:     FlutterWrapperActivity
 * @UpdateDate:     2020/2/25 5:23 PM
 */
class FlutterWrapperActivity : FlutterActivity() {
    val CHANNEL = "com.method.getresult"

    companion object {
        fun startCurrentActivity(context: Context, initRoute: String) {
            //配置启动Intent
            val intent = Intent(context, FlutterWrapperActivity::class.java)
            intent.action = "android.intent.action.RUN"
            intent.putExtra("route", initRoute)
            context.startActivity(intent)
        }
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        registerMethod(flutterEngine)
        var s : ViewModel? = null;
        var da : LiveData<String>?  = null;

    }


    private fun registerMethod(flutterEngine: FlutterEngine) {
        MethodChannel(
            flutterEngine.dartExecutor,
            CHANNEL
        ).setMethodCallHandler { methodCall, result ->
            if (methodCall.method == "getResult") {
                result.success("return result xxx  to flutter") //回调给flutter的参数
            }
        }
    }

}