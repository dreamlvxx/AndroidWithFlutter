package com.dream.android2flutter.flutter.flutter_channel

import io.flutter.plugin.common.MethodChannel
import java.util.*

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.flutter.flutter_channel
 * @ClassName:      MethodChannelManager
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/2/26 3:49 PM
 * @UpdateUser:     MethodChannelManager
 * @UpdateDate:     2020/2/26 3:49 PM
 */

object MethodChannelManager {

    private val channels =
        HashMap<String?, MethodChannel>()

    fun put(name: String?, channel: MethodChannel) {
        channels[name] = channel
    }

    operator fun get(name: String?): MethodChannel {
        return channels[name]
            ?: throw RuntimeException("the method channel has not registered")
    }

    fun clearAll() {
        channels.clear()
    }

}