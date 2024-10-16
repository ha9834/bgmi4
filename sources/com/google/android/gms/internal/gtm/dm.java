package com.google.android.gms.internal.gtm;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
public class dm<K, V> extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ dd f4350a;

    private dm(dd ddVar) {
        this.f4350a = ddVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new dl(this.f4350a, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4350a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f4350a.get(entry.getKey());
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
        this.f4350a.remove(entry.getKey());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f4350a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f4350a.a((dd) entry.getKey(), (Comparable) entry.getValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dm(dd ddVar, de deVar) {
        this(ddVar);
    }
}
