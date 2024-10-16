package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzdtk<K, V> implements zzdti<Map<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzdtu<Map<Object, Object>> f3621a = zzdtj.zzar(Collections.emptyMap());
    private final Map<K, zzdtu<V>> b;

    public static <K, V> zzdtm<K, V> zzho(int i) {
        return new zzdtm<>(i);
    }

    private zzdtk(Map<K, zzdtu<V>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        LinkedHashMap zzhm = zzdtf.zzhm(this.b.size());
        for (Map.Entry<K, zzdtu<V>> entry : this.b.entrySet()) {
            zzhm.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(zzhm);
    }
}
