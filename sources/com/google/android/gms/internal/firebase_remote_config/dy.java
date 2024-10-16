package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
public class dy<K, V> extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ dn f4085a;

    private dy(dn dnVar) {
        this.f4085a = dnVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new dv(this.f4085a, null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4085a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f4085a.get(entry.getKey());
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
        this.f4085a.remove(entry.getKey());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f4085a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f4085a.a((dn) entry.getKey(), (Comparable) entry.getValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dy(dn dnVar, dq dqVar) {
        this(dnVar);
    }
}
