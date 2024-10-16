package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class dk<E> extends bg<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final dk<Object> f4518a;
    private final List<E> b;

    public static <E> dk<E> b() {
        return (dk<E>) f4518a;
    }

    dk() {
        this(new ArrayList(10));
    }

    private dk(List<E> list) {
        this.b = list;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        a();
        this.b.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.b.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        a();
        E remove = this.b.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
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

    @Override // com.google.android.gms.internal.measurement.zzff
    public final /* synthetic */ zzff zzap(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new dk(arrayList);
    }

    static {
        dk<Object> dkVar = new dk<>(new ArrayList(0));
        f4518a = dkVar;
        dkVar.zzry();
    }
}
