package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcrv implements zzcva<zzcuz<Bundle>> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3401a;
    private final zzawm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrv(Executor executor, zzawm zzawmVar) {
        this.f3401a = executor;
        this.b = zzawmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> zzalm() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcri)).booleanValue()) {
            return zzbar.zzm(null);
        }
        return zzbar.zza(this.b.zzvd(), yd.f2631a, this.f3401a);
    }
}
