package com.dream.android2flutter.flutter

import android.content.Context
import android.graphics.Color
import android.view.View
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory


/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.flutter
 * @ClassName:      AndroidView2Flutter
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/16 6:40 PM
 * @UpdateUser:     AndroidView2Flutter
 * @UpdateDate:     2020/3/16 6:40 PM
 */

//视图工厂类
internal class SampleViewFactory (private val messenger: BinaryMessenger) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    //创建原生视图封装类，完成关联
    override fun create(
        context: Context,
        id: Int,
        obj: Any
    ): PlatformView {
        return SimpleViewControl(context, id, messenger)
    }
}

//原生视图封装类
internal class SimpleViewControl(context: Context?, id: Int, messenger: BinaryMessenger?) :
    PlatformView ,MethodChannel.MethodCallHandler{
    private var methodChannel: MethodChannel
    private val view : View//缓存原生视图

    init {
        methodChannel = MethodChannel(messenger, "samples.chenhang/native_views_$id")
        methodChannel.setMethodCallHandler(this)
    }
    //返回原生视图
    override fun getView(): View {
        return view
    }

    //初始化方法，提前创建好视图
    init {
        view = View(context)
        view.setBackgroundColor(Color.rgb(255, 0, 0))
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        if (call.method.equals("changeBackgroundColor")){
            view.setBackgroundColor(Color.rgb(0, 0, 255))
            result.success(0)
        }else{
            result.notImplemented()
        }
    }

    //原生视图销毁回调
    override fun dispose() {

    }
}