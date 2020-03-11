package com.dream.android2flutter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dream.android2flutter.R
import com.dream.android2flutter.viewmodel.MainModel
import kotlinx.android.synthetic.main.activity_second_layout.*

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.ui
 * @ClassName:      SecondActivity
 * @Description:
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/10 3:53 PM
 * @UpdateUser:     SecondActivity
 * @UpdateDate:     2020/3/10 3:53 PM
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_layout)
        tv_second_notify.setOnClickListener {
            val model: MainModel =
                ViewModelProvider(this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application))
                    .get(MainModel::class.java)
            model.msg.postValue("newnewnew")
        }
    }
}