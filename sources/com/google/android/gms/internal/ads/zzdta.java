package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class zzdta<E> extends AbstractList<E> {
    private static final zzdtc c = zzdtc.zzm(zzdta.class);

    /* renamed from: a, reason: collision with root package name */
    List<E> f3616a;
    Iterator<E> b;

    public zzdta(List<E> list, Iterator<E> it) {
        this.f3616a = list;
        this.b = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.f3616a.size() > i) {
            return this.f3616a.get(i);
        }
        if (this.b.hasNext()) {
            this.f3616a.add(this.b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new aip(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        c.zzhc("potentially expensive size() call");
        c.zzhc("blowup running");
        while (this.b.hasNext()) {
            this.f3616a.add(this.b.next());
        }
        return this.f3616a.size();
    }
}
