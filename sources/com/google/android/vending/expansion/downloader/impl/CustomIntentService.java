package com.google.android.vending.expansion.downloader.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes2.dex */
public abstract class CustomIntentService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private String f5366a;
    private boolean b;
    private volatile a c;
    private volatile Looper d;

    protected abstract void a(Intent intent);

    protected abstract boolean e();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public CustomIntentService(String str) {
        this.f5366a = str;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("IntentService[" + this.f5366a + "]");
        handlerThread.start();
        this.d = handlerThread.getLooper();
        this.c = new a(this.d);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Thread thread = this.d.getThread();
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        this.d.quit();
        Log.d("CustomIntentService", "onDestroy");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (this.c.hasMessages(-10)) {
            return;
        }
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.arg1 = i;
        obtainMessage.obj = intent;
        obtainMessage.what = -10;
        this.c.sendMessage(obtainMessage);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return this.b ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CustomIntentService.this.a((Intent) message.obj);
            if (CustomIntentService.this.e()) {
                Log.d("CustomIntentService", "stopSelf");
                CustomIntentService.this.stopSelf(message.arg1);
                Log.d("CustomIntentService", "afterStopSelf");
            }
        }
    }
}
