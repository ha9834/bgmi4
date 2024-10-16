package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MediaCodec.CryptoException f1915a;
    private final /* synthetic */ zzgr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajk(zzgr zzgrVar, MediaCodec.CryptoException cryptoException) {
        this.b = zzgrVar;
        this.f1915a = cryptoException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgw zzgwVar;
        zzgwVar = this.b.i;
        zzgwVar.zzb(this.f1915a);
    }
}
