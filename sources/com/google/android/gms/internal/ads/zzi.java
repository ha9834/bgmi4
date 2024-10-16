package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzi implements zzab {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3652a;

    public zzi(Handler handler) {
        this.f3652a = new akh(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void zzb(zzr<?> zzrVar, zzy<?> zzyVar) {
        zza(zzrVar, zzyVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void zza(zzr<?> zzrVar, zzy<?> zzyVar, Runnable runnable) {
        zzrVar.zzk();
        zzrVar.zzb("post-response");
        this.f3652a.execute(new akr(zzrVar, zzyVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final void zza(zzr<?> zzrVar, zzaf zzafVar) {
        zzrVar.zzb("post-error");
        this.f3652a.execute(new akr(zzrVar, zzy.zzc(zzafVar), null));
    }
}
