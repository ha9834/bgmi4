package com.uqm.crashsight.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.crash.c;
import com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler;
import com.uqm.crashsight.proguard.q;
import java.io.File;

/* loaded from: classes3.dex */
public class ResidentService extends Service {
    static boolean isNativeDaemonInit;
    private a binder = new a(this);
    long bootTime = 0;
    private CrashSightStrategy.a callback;

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    /* loaded from: classes3.dex */
    public class a extends Binder {
        public a(ResidentService residentService) {
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i("ResidentService", "ResidentService -> onCreate, Thread: " + Thread.currentThread().getName());
        com.uqm.crashsight.crashreport.common.info.a a2 = com.uqm.crashsight.crashreport.common.info.a.a(this);
        c.a(1004, (Context) this, true, this.callback, (com.uqm.crashsight.proguard.c) null, (String) null);
        boolean z = !q.a(a2.n);
        String str = "CrashSight";
        String str2 = a2.n;
        if (z) {
            str = str2;
        } else {
            a2.getClass();
        }
        NativeCrashHandler.getInstance().tryLoadSo(str, z);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.bootTime = intent.getExtras().getLong("BootTime");
        Log.i("ResidentService", "ResidentService -> bootTime: " + String.valueOf(this.bootTime));
        if (!isNativeDaemonInit) {
            isNativeDaemonInit = true;
            new Thread() { // from class: com.uqm.crashsight.service.ResidentService.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    File dir = this.getDir("indicators", 0);
                    NativeCrashHandler.nativeDaemonInit(new File(dir, "indicator_p").getAbsolutePath(), new File(dir, "indicator_d").getAbsolutePath(), new File(dir, "observer_p").getAbsolutePath(), new File(dir, "observer_d").getAbsolutePath(), NativeCrashHandler.getInstance().getDumpFilePath(), ResidentService.this.bootTime);
                }
            }.start();
        }
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.i("ResidentService", "ResidentService onUnbind");
        return false;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i("ResidentService", "ResidentService onDestroy");
        super.onDestroy();
    }
}
