package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cl<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f4504a;

    public cl(Iterator<Map.Entry<K, Object>> it) {
        this.f4504a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4504a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f4504a.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f4504a.next();
        return next.getValue() instanceof zzfj ? new cj(next) : next;
    }
}
