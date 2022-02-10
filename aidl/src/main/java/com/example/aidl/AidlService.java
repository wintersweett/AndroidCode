package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

public class AidlService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BinderHolder();
    }

    public class BinderHolder extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    }
}
