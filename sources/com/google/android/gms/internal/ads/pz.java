package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
final class pz implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<zzbxx> f2429a;

    private pz(zzbxx zzbxxVar) {
        this.f2429a = new WeakReference<>(zzbxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        zzbxx zzbxxVar = this.f2429a.get();
        if (zzbxxVar != null && "_ac".equals(map.get("eventName"))) {
            zzbxx.b(zzbxxVar).onAdClicked();
        }
    }
}
