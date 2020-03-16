package com.dream.android2flutter.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.dream.android2flutter.R;
import com.dream.android2flutter.utils.AnimatorUtils;

/**
 * @ProjectName: Android2Flutter
 * @Package: com.dream.android2flutter.widget
 * @ClassName: ClipBoardViewJ
 * @Description: 数字翻页效果的view 例如角标的1变成2，有一个滑动的效果
 * @Author: xingxinglv
 * @CreateDate: 2020/3/12 10:32 AM
 * @UpdateUser: ClipBoardViewJ
 * @UpdateDate: 2020/3/12 10:32 AM
 */
public class ClipBoardViewJ extends LinearLayout implements View.OnClickListener {
    private View content;
    private TextView mTvClipOne;
    private TextView mTvClipTwo;
    private float scrollDistance = 0;

    public ClipBoardViewJ(Context context) {
        this(context, null);
    }

    public ClipBoardViewJ(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipBoardViewJ(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView() {
        content = View.inflate(getContext(), R.layout.view_clip_board_layout, this);
        content.post(new Runnable() {
            @Override
            public void run() {
                scrollDistance = mTvClipOne.getHeight();
            }
        });
        mTvClipOne = content.findViewById(R.id.tv_clip_one);
        mTvClipTwo = content.findViewById(R.id.tv_clip_two);
        content.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("xxx", "onClick: + height" + scrollDistance);
        new AnimatorUtils.Builder(mTvClipOne)
                .translateY(0, -scrollDistance)
                .setDuration(300)
                .build().start();
        new AnimatorUtils.Builder(mTvClipTwo)
                .translateY(0, -scrollDistance)
                .setDuration(300)
                .build().start();
    }
}
