package com.tencent.imsdk.android.webview.qq;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Messenger;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class WebViewService extends Service {
    private static HandlerThread mClientHandlerThread;
    private static HandlerThread mServerHandlerThread;
    private static Messenger sMessenger;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setMessenger(Messenger messenger) {
        sMessenger = messenger;
    }

    private static void quiteHandlerThreadSafely(HandlerThread handlerThread) {
        if (handlerThread != null) {
            try {
                if (handlerThread.isAlive()) {
                    handlerThread.quit();
                }
            } catch (Exception e) {
                IMLogger.e(e.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setServerHandlerThread(HandlerThread handlerThread) {
        quiteHandlerThreadSafely(mServerHandlerThread);
        mServerHandlerThread = handlerThread;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setClientHandlerThread(HandlerThread handlerThread) {
        quiteHandlerThreadSafely(mClientHandlerThread);
        mClientHandlerThread = handlerThread;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        IMLogger.d("onCreate");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (sMessenger == null) {
            return null;
        }
        IMLogger.d("onBind");
        return sMessenger.getBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IMLogger.d("onUnbind");
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        IMLogger.d("onDestroy");
        quiteHandlerThreadSafely(mServerHandlerThread);
        mServerHandlerThread = null;
        quiteHandlerThreadSafely(mClientHandlerThread);
        mClientHandlerThread = null;
    }
}
