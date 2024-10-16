package com.huawei.game.gamekit.b;

import android.content.Context;

/* loaded from: classes2.dex */
public final class b {
    private static final String c = "HapticsUtil";
    private static final Object d = new Object();
    private static b e;

    /* renamed from: a, reason: collision with root package name */
    public com.huawei.devices.hapticskit.a f5472a;
    public com.huawei.devices.hapticskit.b b;

    private b() {
    }

    public static b a() {
        b bVar;
        synchronized (d) {
            if (e == null) {
                e = new b();
            }
            bVar = e;
        }
        return bVar;
    }

    private void a(Context context) {
        c.c(c, "init Haptics Util");
        this.f5472a = new com.huawei.devices.hapticskit.a(context);
        this.b = this.f5472a.a();
    }

    private void a(String str) {
        com.huawei.devices.hapticskit.b bVar = this.b;
        if (bVar == null) {
            c.c(c, "HapticsUtil mHapticsAdapter is null");
            return;
        }
        bVar.a(str);
        c.b(c, "setVibrationLevel Success:" + str);
    }
}
