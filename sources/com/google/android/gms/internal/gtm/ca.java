package com.google.android.gms.internal.gtm;

import java.util.Map;

/* loaded from: classes2.dex */
final class ca<K> implements Map.Entry<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    private Map.Entry<K, zzrn> f4328a;

    private ca(Map.Entry<K, zzrn> entry) {
        this.f4328a = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f4328a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f4328a.getValue() == null) {
            return null;
        }
        return zzrn.zzpy();
    }

    public final zzrn a() {
        return this.f4328a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzsk)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.f4328a.getValue().zzi((zzsk) obj);
    }
}
