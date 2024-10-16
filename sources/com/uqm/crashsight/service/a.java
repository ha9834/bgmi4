package com.uqm.crashsight.service;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.uqm.crashsight.crashreport.common.info.c;
import com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static Semaphore f6841a;
    private static volatile boolean b;
    private static Application.ActivityLifecycleCallbacks g;
    private Context c;
    private int d;
    private int e;
    private ActivityManager.RunningAppProcessInfo f = new ActivityManager.RunningAppProcessInfo();
    private List<p.a> h;
    private int i;

    static /* synthetic */ void a(a aVar) {
        if (b) {
            b = false;
            f6841a.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, int i, int i2, int i3, boolean z) {
        this.i = 0;
        b = false;
        this.c = context;
        this.d = i;
        this.e = i2;
        f6841a = new Semaphore(0);
        this.h = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            this.h.add(new p.a());
        }
        this.i = 0;
        p.a(NativeCrashHandler.getInstance());
        p.b(this.d);
        p.a(z);
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (g != null) {
                        return;
                    }
                    g = new Application.ActivityLifecycleCallbacks() { // from class: com.uqm.crashsight.service.a.1
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityDestroyed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityStarted(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityStopped(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityResumed(Activity activity) {
                            a.a(a.this);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityPaused(Activity activity) {
                            a aVar = a.this;
                            a.b = true;
                        }
                    };
                    application.registerActivityLifecycleCallbacks(g);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }

    public final void a() {
        Thread thread = new Thread(this);
        thread.setName("CrashSight_Routine");
        thread.start();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"ObsoleteSdkInt"})
    public final void run() {
        long j = 0;
        long j2 = 0;
        while (true) {
            if (b) {
                try {
                    m.a("Routine wait", new Object[0]);
                    f6841a.acquire();
                    m.a("Routine wakeup", new Object[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (j == 0 || (this.e * 1000) + j < System.currentTimeMillis()) {
                    j = System.currentTimeMillis();
                    Context context = this.c;
                    p.a(c.a(this.f));
                }
                if (Build.VERSION.SDK_INT >= 14 && (j2 == 0 || (this.d * 1000) + j2 < System.currentTimeMillis())) {
                    j2 = System.currentTimeMillis();
                    Context context2 = this.c;
                    p.b();
                    System.currentTimeMillis();
                    List<p.a> list = this.h;
                    int i = this.i;
                    this.i = i + 1;
                    p.a(list, i);
                    NativeCrashHandler.getInstance().updateMemInfo(p.a(this.h));
                }
                p.a();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
