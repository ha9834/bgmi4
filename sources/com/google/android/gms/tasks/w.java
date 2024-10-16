package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ v f5201a;
    private final /* synthetic */ Callable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, Callable callable) {
        this.f5201a = vVar;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5201a.a((v) this.b.call());
        } catch (Exception e) {
            this.f5201a.a(e);
        }
    }
}
