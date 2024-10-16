package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class aov implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f2018a;
    private final /* synthetic */ zzuu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aov(zzuu zzuuVar, View view) {
        this.b = zzuuVar;
        this.f2018a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f2018a);
    }
}
