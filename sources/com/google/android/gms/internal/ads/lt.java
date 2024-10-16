package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class lt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f2327a;
    private final /* synthetic */ zzavb b;
    private final /* synthetic */ int c;
    private final /* synthetic */ zzbio d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lt(zzbio zzbioVar, View view, zzavb zzavbVar, int i) {
        this.d = zzbioVar;
        this.f2327a = view;
        this.b = zzavbVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a(this.f2327a, this.b, this.c - 1);
    }
}
