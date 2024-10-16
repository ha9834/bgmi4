package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class aft<K> implements Map.Entry<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    private Map.Entry<K, zzdon> f1854a;

    private aft(Map.Entry<K, zzdon> entry) {
        this.f1854a = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f1854a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f1854a.getValue() == null) {
            return null;
        }
        return zzdon.zzaym();
    }

    public final zzdon a() {
        return this.f1854a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzdpk)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.f1854a.getValue().zzq((zzdpk) obj);
    }
}
