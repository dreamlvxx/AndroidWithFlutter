package com.dream.android2flutter.flutter

import android.content.Context
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterSurfaceView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


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

    override fun onFlutterSurfaceViewCreated(flutterSurfaceView: FlutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        super.configureFlutterEngine(flutterEngine)
        registerMethod(flutterEngine)

        //TODO 这里有错误

//        flutterEngine.platformViewsController.registry
//            .registerViewFactory("sampleView",SampleViewFactory(flutterEngine.dartExecutor.binaryMessenger))
//
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