package com.google.android.gms.internal.firebase_remote_config;

import java.util.Map;

/* loaded from: classes2.dex */
final class ck<K> implements Map.Entry<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    private Map.Entry<K, zzhr> f4062a;

    private ck(Map.Entry<K, zzhr> entry) {
        this.f4062a = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f4062a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f4062a.getValue() == null) {
            return null;
        }
        return zzhr.zzho();
    }

    public final zzhr a() {
        return this.f4062a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzim)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.f4062a.getValue().zzi((zzim) obj);
    }
}
