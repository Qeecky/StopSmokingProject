package com.example.stopsmokin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NotService extends Service  {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    //@Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
