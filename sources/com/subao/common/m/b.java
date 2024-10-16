package com.subao.common.m;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private static final b f6128a = new b();
    private final Handler b = new Handler(Looper.getMainLooper());

    private b() {
    }

    public static a a() {
        return f6128a;
    }

    @Override // com.subao.common.m.a
    public boolean a(Runnable runnable) {
        return this.b.post(runnable);
    }

    @Override // com.subao.common.m.a
    public boolean a(Runnable runnable, long j) {
        return this.b.postDelayed(runnable, j);
    }

    @Override // com.subao.common.m.a
    public void b(Runnable runnable) {
        this.b.removeCallbacks(runnable);
    }
}
