package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class ds<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private int f4522a;
    private Iterator<Map.Entry<K, V>> b;
    private final /* synthetic */ dq c;

    private ds(dq dqVar) {
        List list;
        this.c = dqVar;
        list = this.c.b;
        this.f4522a = list.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f4522a;
        if (i > 0) {
            list = this.c.b;
            if (i <= list.size()) {
                return true;
            }
        }
        return a().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        Map map;
        if (this.b == null) {
            map = this.c.f;
            this.b = map.entrySet().iterator();
        }
        return this.b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (a().hasNext()) {
            return a().next();
        }
        list = this.c.b;
        int i = this.f4522a - 1;
        this.f4522a = i;
        return (Map.Entry) list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ds(dq dqVar, dp dpVar) {
        this(dqVar);
    }
}
