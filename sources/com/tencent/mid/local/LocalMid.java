package com.tencent.mid.local;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class LocalMid {

    /* renamed from: a, reason: collision with root package name */
    private static Context f6264a;
    private static Handler b;
    private static LocalMid c;

    private LocalMid(Context context) {
        HandlerThread handlerThread = new HandlerThread(LocalMid.class.getSimpleName());
        handlerThread.start();
        b = new Handler(handlerThread.getLooper());
        f6264a = context.getApplicationContext();
    }

    public static LocalMid getInstance(Context context) {
        if (c == null) {
            synchronized (LocalMid.class) {
                if (c == null) {
                    c = new LocalMid(context);
                }
            }
        }
        return c;
    }

    public String getLocalMid() {
        return h.a(f6264a).a().c;
    }

    public boolean isMidValid(String str) {
        return i.c(str);
    }
}
