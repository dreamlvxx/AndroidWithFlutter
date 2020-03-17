package com.dream.android2flutter.bind_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 *
 * @ProjectName:    Android2Flutter
 * @Package:        com.dream.android2flutter.bind_adapter
 * @ClassName:      ImageViewAdapter
 * @Description:    自定义adapter
 * @Author:         xingxinglv
 * @CreateDate:     2020/3/17 5:27 PM
 * @UpdateUser:     ImageViewAdapter
 * @UpdateDate:     2020/3/17 5:27 PM
 */
class ImageViewAdapter {

    companion object{
        @JvmStatic
        @BindingAdapter(value = ["xxval","ttq"],requireAll = false)
        fun setXxval(view : TextView,  url : String,texts : String?){
            print("loadImage")
            view.text = url + "adapter"
            texts?.let {
                view.text = texts + "22222"
            }
        }
    }
}