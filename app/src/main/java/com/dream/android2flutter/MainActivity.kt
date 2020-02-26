package com.dream.android2flutter

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dream.android2flutter.ui.base.FlutterBaseActivity
import io.flutter.view.FlutterMain


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FlutterMain.ensureInitializationComplete(applicationContext,getArgsFromIntent(intent))
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_btn).setOnClickListener {
            FlutterBaseActivity.startCurrentActivity(this@MainActivity,"home")
         }
    }

    //在向此列表中添加更多条目之前，请考虑任意
    // Android应用程序可以生成具有额外数​​据的意图，并且
    // 二进制文件中存在许多安全敏感的args。
    private fun getArgsFromIntent(intent: Intent): Array<String>? {
        var arrayList = arrayListOf<String>();
        if (intent.getBooleanExtra("trace-startup", false)) {
            arrayList.add("--trace-startup")
        }
        if (intent.getBooleanExtra("start-paused", false)) {
            arrayList.add("--start-paused")
        }
        if (intent.getBooleanExtra("enable-dart-profiling", false)) {
            arrayList.add("--enable-dart-profiling")
        }
        if (!arrayList.isEmpty()) {
            val argsArray = arrayOfNulls<String>(arrayList.size)
            return arrayList.toArray(argsArray)
        }
        return null
    }
}
