package com.dream.android2flutter.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: android
 * @Package: com.qingclass.yiban.utils
 * @ClassName: AnimatorUtils
 * @Description:
 * @Author: xingxinglv
 * @CreateDate: 2020/3/6 10:59 AM
 * @UpdateUser: AnimatorUtils
 * @UpdateDate: 2020/3/6 10:59 AM
 */
public class AnimatorUtils {
    private View target;
    private List<Animator> list;
    private long duration = 0;
    private TimeInterpolator interpolator;

    private AnimatorUtils(Builder builder){
        list = new ArrayList<>();
        this.list = builder.list;
        this.target = builder.target;
        this.duration = builder.duration;
        this.interpolator = builder.interpolator;
    }

    public static class Builder{
        private View target;
        private List<Animator> list = new ArrayList<>();
        private long duration;
        private TimeInterpolator interpolator;

        public Builder(View target) {
            this.target = target;
        }

        public Builder translateX(float...values){
            list.add(ObjectAnimator.ofFloat(target,"translationX",values));
            return this;
        }

        public Builder translateY(float...values){
            list.add(ObjectAnimator.ofFloat(target,"translationY",values));
            return this;
        }

        public Builder scaleX(float...values){
            list.add(ObjectAnimator.ofFloat(target,"scaleX",values));
            return this;
        }

        public Builder scaleY(float...values){
            list.add(ObjectAnimator.ofFloat(target,"scaleY",values));
            return this;
        }

        public Builder rotation(float...values){
            list.add(ObjectAnimator.ofFloat(target,"rotation",values));
            return this;
        }

        public Builder setDuration(long duration){
            this.duration = duration;
            return this;
        }

        public Builder setInterpolator(TimeInterpolator interpolator){
            this.interpolator = interpolator;
            return this;
        }

        public AnimatorUtils build(){
            return new AnimatorUtils(this);
        }

    }


    public void start(){
        if (duration == 0
            || list.isEmpty())
        {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setTarget(target);
        animatorSet.playTogether(list);
        animatorSet.setDuration(duration);
        animatorSet.setInterpolator(interpolator);
        animatorSet.start();
    }

}
