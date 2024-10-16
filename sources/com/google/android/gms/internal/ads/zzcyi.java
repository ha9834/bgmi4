package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcyi implements zzaws, zzbro {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final HashSet<zzawj> f3499a = new HashSet<>();
    private final Context b;
    private final zzawu c;

    public zzcyi(Context context, zzawu zzawuVar) {
        this.b = context;
        this.c = zzawuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.c.zzb(this.f3499a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaws
    public final synchronized void zza(HashSet<zzawj> hashSet) {
        this.f3499a.clear();
        this.f3499a.addAll(hashSet);
    }

    public final Bundle zzams() {
        return this.c.zza(this.b, this);
    }
}
