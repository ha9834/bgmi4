package com.shieldtunnel.svpn.common.j;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class b implements a {
    private static final b b = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f5853a = new Handler(Looper.getMainLooper());

    private b() {
    }

    public static a a() {
        return b;
    }

    @Override // com.shieldtunnel.svpn.common.j.a
    public boolean b(Runnable runnable) {
        return this.f5853a.post(runnable);
    }

    @Override // com.shieldtunnel.svpn.common.j.a
    public boolean a(Runnable runnable, long j) {
        return this.f5853a.postDelayed(runnable, j);
    }

    @Override // com.shieldtunnel.svpn.common.j.a
    public void a(Runnable runnable) {
        this.f5853a.removeCallbacks(runnable);
    }
}
