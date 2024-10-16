package com.google.android.gms.internal.measurement;

import java.util.Map;

/* loaded from: classes2.dex */
final class cj<K> implements Map.Entry<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    private Map.Entry<K, zzfj> f4503a;

    private cj(Map.Entry<K, zzfj> entry) {
        this.f4503a = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f4503a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f4503a.getValue() == null) {
            return null;
        }
        return zzfj.zzvc();
    }

    public final zzfj a() {
        return this.f4503a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzgi)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.f4503a.getValue().zzi((zzgi) obj);
    }
}
