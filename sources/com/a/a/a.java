package com.a.a;

import android.os.Handler;

/* loaded from: classes.dex */
public class a implements com.a.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f935a = new Handler();

    @Override // com.a.a.a.b
    public void a(Runnable runnable) {
        this.f935a.post(runnable);
    }
}
