package com.dream.android2flutter.flutter.flutter_channel

import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.view.FlutterNativeView

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.flutter.flutter_channel
 * @ClassName:      MethodManager
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/2/26 3:43 PM
 * @UpdateUser:     MethodManager
 * @UpdateDate:     2020/2/26 3:43 PM
 */

class MethodChannelRegister(engine: FlutterNativeView) {

    private val engine: FlutterNativeView = engine
    private val manager : MethodChannelManager = MethodChannelManager

    fun register(name: String?, handler: MethodCallHandler?): MethodChannel {
        val channel = MethodChannel(engine, name)
        channel.setMethodCallHandler(handler)
        manager.put(name, channel)
        return channel
    }

    fun unregisterAll() {
        manager.clearAll()
    }

}

