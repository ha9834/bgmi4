package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Surface f1919a;
    private final /* synthetic */ zzhd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajr(zzhd zzhdVar, Surface surface) {
        this.b = zzhdVar;
        this.f1919a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhh zzhhVar;
        zzhhVar = this.b.c;
        zzhhVar.zza(this.f1919a);
    }
}
