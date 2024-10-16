package com.tencent.mid.a;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile i f6257a;
    private Handler b;

    private i() {
        this.b = null;
        HandlerThread handlerThread = new HandlerThread("MidWorkThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
    }

    public static i a() {
        if (f6257a == null) {
            synchronized (i.class) {
                if (f6257a == null) {
                    f6257a = new i();
                }
            }
        }
        return f6257a;
    }

    public void a(Runnable runnable) {
        Handler handler = this.b;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
