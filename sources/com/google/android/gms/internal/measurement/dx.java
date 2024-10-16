package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
public class dx<K, V> extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ dq f4525a;

    private dx(dq dqVar) {
        this.f4525a = dqVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new dy(this.f4525a, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4525a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f4525a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f4525a.remove(entry.getKey());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f4525a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f4525a.a((dq) entry.getKey(), (Comparable) entry.getValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dx(dq dqVar, dp dpVar) {
        this(dqVar);
    }
}
