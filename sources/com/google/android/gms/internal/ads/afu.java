package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class afu<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f1855a;

    public afu(Iterator<Map.Entry<K, Object>> it) {
        this.f1855a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1855a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f1855a.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f1855a.next();
        return next.getValue() instanceof zzdon ? new aft(next) : next;
    }
}
