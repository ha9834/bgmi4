package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public final class zzdtm<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, zzdtu<V>> f3622a;

    private zzdtm(int i) {
        this.f3622a = zzdtf.zzhm(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzdtm<K, V> zza(K k, zzdtu<V> zzdtuVar) {
        this.f3622a.put(zzdto.zza(k, "key"), (zzdtu) zzdto.zza(zzdtuVar, "provider"));
        return this;
    }

    public final zzdtk<K, V> zzbbf() {
        return new zzdtk<>(this.f3622a);
    }
}
