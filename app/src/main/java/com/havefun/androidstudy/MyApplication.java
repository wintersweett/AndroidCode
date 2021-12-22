package com.havefun.androidstudy;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends com.havefun.base.BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
