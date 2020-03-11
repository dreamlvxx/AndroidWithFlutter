package com.dream.android2flutter.flutter.flutter_channel

import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

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

class MethodChannelRegister(engine: FlutterEngine) {

    private val engine: FlutterEngine = engine
    private val manager : MethodChannelManager = MethodChannelManager

    fun register(name: String?, handler: MethodCallHandler?): MethodChannel {
        val channel = MethodChannel(engine.dartExecutor, name)
        channel.setMethodCallHandler(handler)
        manager.put(name, channel)
        return channel
    }

    fun unregisterAll() {
        manager.clearAll()
    }

}

