package com.huawei.devices.hapticskit;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5459a = "HapticsKit";
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 24;
    private static final long e = 3600000;
    private HandlerThread f;
    private Handler g;
    private long h = 0;
    private String i;
    private Context j;

    protected a() {
    }

    public a(Context context) {
        this.j = context;
    }

    private void b() {
        this.i = this.j.getPackageName();
        if (this.i != null) {
            return;
        }
        Log.d("HapticsKit", "Context.getPackageName is null");
        throw new c("Context.getPackageName is null");
    }

    public final b a() {
        if (this.j == null) {
            Log.e("HapticsKit", "context values is NULL");
            throw new c("NullPointerException");
        }
        Log.d("HapticsKit", "HapticsKitAdapter initialize");
        this.i = this.j.getPackageName();
        if (this.i != null) {
            return new d(this.g, this.j);
        }
        Log.d("HapticsKit", "Context.getPackageName is null");
        throw new c("Context.getPackageName is null");
    }
}
