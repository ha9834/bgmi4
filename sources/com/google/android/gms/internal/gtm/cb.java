package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cb<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f4329a;

    public cb(Iterator<Map.Entry<K, Object>> it) {
        this.f4329a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4329a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f4329a.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f4329a.next();
        return next.getValue() instanceof zzrn ? new ca(next) : next;
    }
}
