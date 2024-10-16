package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class agt<E> extends aem<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final agt<Object> f1869a;
    private final List<E> b;

    public static <E> agt<E> b() {
        return (agt<E>) f1869a;
    }

    agt() {
        this(new ArrayList(10));
    }

    private agt(List<E> list) {
        this.b = list;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        a();
        this.b.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.b.get(i);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        a();
        E remove = this.b.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        a();
        E e2 = this.b.set(i, e);
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new agt(arrayList);
    }

    static {
        agt<Object> agtVar = new agt<>(new ArrayList(0));
        f1869a = agtVar;
        agtVar.zzavj();
    }
}
