package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

/* loaded from: classes2.dex */
final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ComponentName f4366a;
    private final /* synthetic */ zzav b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(zzav zzavVar, ComponentName componentName) {
        this.b = zzavVar;
        this.f4366a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzat.a(this.b.f4391a, this.f4366a);
    }
}
