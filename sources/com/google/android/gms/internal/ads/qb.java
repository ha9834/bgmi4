package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
final class qb implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zzbxx> f2432a;

    private qb(zzbxx zzbxxVar) {
        this.f2432a = new WeakReference<>(zzbxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        zzbxx zzbxxVar = this.f2432a.get();
        if (zzbxxVar == null) {
            return;
        }
        zzbxx.a(zzbxxVar).onAdImpression();
    }
}
