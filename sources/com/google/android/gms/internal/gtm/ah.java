package com.google.android.gms.internal.gtm;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ah implements zzbw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Runnable f4297a;
    private final /* synthetic */ zzcq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(zzcq zzcqVar, Runnable runnable) {
        this.b = zzcqVar;
        this.f4297a = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzbw
    public final void zza(Throwable th) {
        Handler handler;
        handler = this.b.f4411a;
        handler.post(this.f4297a);
    }
}
