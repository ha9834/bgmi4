package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cj<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f4061a;

    public cj(Iterator<Map.Entry<K, Object>> it) {
        this.f4061a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4061a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f4061a.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f4061a.next();
        return next.getValue() instanceof zzhr ? new ck(next) : next;
    }
}
