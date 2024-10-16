package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes2.dex */
final class gc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ComponentName f4877a;
    private final /* synthetic */ zzin b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(zzin zzinVar, ComponentName componentName) {
        this.b = zzinVar;
        this.f4877a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f4949a.a(this.f4877a);
    }
}
