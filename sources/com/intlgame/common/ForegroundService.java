package com.intlgame.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.h;
import com.intlgame.common.binder.WebViewAIDLBinder;
import com.intlgame.foundation.INTLLog;

/* loaded from: classes2.dex */
public class ForegroundService extends Service {
    private static final String CHANNEL_ID = "com.intlgame.common";
    public static final String FOREGROUND_SERVICE_ACTION = "com.intlgame.ACTION_FOREGROUND_SERVICE";
    private static final int SERVICE_ID = 1;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        INTLLog.i("ForegroundService start for keep process alive !!!");
    }

    @Override // android.app.Service
    public void onDestroy() {
        WebViewUtil.clearKeepAliveComponentName();
        stopForeground(true);
        super.onDestroy();
        INTLLog.i("ForegroundService for keep process alive destroyed !!!");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null || action.trim().length() <= 0 || !FOREGROUND_SERVICE_ACTION.equals(action)) {
            return null;
        }
        return new WebViewAIDLBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                INTLLog.i("ForegroundService for keep process alive is starting : sdk-version [16, 26)");
                startForeground(1, new Notification());
            } else {
                INTLLog.i("ForegroundService for keep process alive is starting : sdk-version [26, 30+]");
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "ForegroundService", 1));
                    startForeground(1, new h.e(this, CHANNEL_ID).b());
                }
            }
        } catch (Exception e) {
            INTLLog.e("onStartCommand error, " + e.getMessage());
            e.printStackTrace();
        }
        return 1;
    }
}
