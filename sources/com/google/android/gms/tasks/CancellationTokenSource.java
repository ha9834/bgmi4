package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
public class CancellationTokenSource {

    /* renamed from: a, reason: collision with root package name */
    private final a f5176a = new a();

    public CancellationToken getToken() {
        return this.f5176a;
    }

    public void cancel() {
        this.f5176a.a();
    }
}
