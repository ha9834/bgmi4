package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class dh<E> extends bc<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final dh<Object> f4075a;
    private final List<E> b;

    public static <E> dh<E> b() {
        return (dh<E>) f4075a;
    }

    dh() {
        this(new ArrayList(10));
    }

    private dh(List<E> list) {
        this.b = list;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        a();
        this.b.add(i, e);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.b.get(i);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        a();
        E remove = this.b.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
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

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhn
    public final /* synthetic */ zzhn zzu(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new dh(arrayList);
    }

    static {
        dh<Object> dhVar = new dh<>(new ArrayList(0));
        f4075a = dhVar;
        dhVar.zzeu();
    }
}
