package com.havefun.androidstudy;

import android.app.Application;

import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.launcher.ARouter;

import java.lang.reflect.Field;
import java.util.Map;

public class MyApplication extends com.havefun.base.BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        try {
            Class<?> clazz = Class.forName("com.alibaba.android.arouter.core.Warehouse");
            Field field = clazz.getDeclaredField("routes");
            field.setAccessible(true);
            Map<String, RouteMeta> map = (Map<String, RouteMeta>) field.get(null);
            int size = map.size();
            System.out.println("ZHANG: size:  " + size);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ARouter.monitorMode();
        ARouter.openLog();
        ARouter.init(this);

        try {
            Class<?> clazz = Class.forName("com.alibaba.android.arouter.core.Warehouse");
            Field field = clazz.getDeclaredField("routes");
            field.setAccessible(true);
            Map<String, RouteMeta> map = (Map<String, RouteMeta>) field.get(null);
            int size = map.size();
            System.out.println("ZHANG: size:  " + size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
