package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aoh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Surface f2004a;
    private final /* synthetic */ zzto b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aoh(zzto zztoVar, Surface surface) {
        this.b = zztoVar;
        this.f2004a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.b.b;
        zztnVar.zzb(this.f2004a);
    }
}
