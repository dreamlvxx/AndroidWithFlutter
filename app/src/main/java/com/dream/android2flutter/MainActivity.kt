package com.dream.android2flutter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dream.android2flutter.ui.base.FlutterBaseActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_btn).setOnClickListener {
            FlutterBaseActivity.startCurrentActivity(this@MainActivity,"home")
         }
    }
}
