package com.havefun.shortcode.manager;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class ListenerManager {

    private static Set<BaseEvent> sMemCache = new TreeSet<>();

    /**
     * 单例模式
     */
    public static ListenerManager listenerManager;

    /**
     * 注册的接口集合，发送广播的时候都能收到
     */
    private List<IListener> iListenerList = new CopyOnWriteArrayList<IListener>();

    /**
     * 获得单例对象
     */
    public static ListenerManager getInstance() {
        if (listenerManager == null) {
            listenerManager = new ListenerManager();
        }
        return listenerManager;
    }

    /**
     * 注册监听
     */
    public void registerListener(IListener iListener) {
        if (iListenerList.contains(iListener)) {
            return;
        }
        iListenerList.add(iListener);
        if (!sMemCache.isEmpty()) {
            update();
        }
    }

    /**
     * 注销监听
     */
    public void unRegisterListener(IListener iListener) {
        if (iListenerList.contains(iListener)) {
            iListenerList.remove(iListener);
        }
    }

    /**
     * 发送广播
     */
    public void sendBroadCast(BaseEvent baseEvent) {
        for (IListener iListener : iListenerList) {
            iListener.notifyAllActivity(baseEvent);
        }
        if (iListenerList.isEmpty()) {
            sMemCache.add(baseEvent);
        }
    }

    public void update() {
        for (IListener iListener : iListenerList) {
            Iterator<BaseEvent> iterator = sMemCache.iterator();
            while (iterator.hasNext()) {
                iListener.notifyAllActivity(iterator.next());
            }
        }
    }

}
