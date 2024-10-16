package com.google.android.gms.internal;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzcvi<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<K, WeakReference<V>> f4712a = new WeakHashMap();

    public final void clear() {
        this.f4712a.clear();
    }

    public final boolean containsKey(K k) {
        return get(k) != null;
    }

    public final V get(K k) {
        WeakReference<V> weakReference = this.f4712a.get(k);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void remove(K k) {
        this.f4712a.remove(k);
    }

    public final void zzf(K k, V v) {
        this.f4712a.put(k, new WeakReference<>(v));
    }
}
