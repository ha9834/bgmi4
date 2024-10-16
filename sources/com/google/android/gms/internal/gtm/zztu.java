package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zztu extends AbstractList<String> implements zzrt, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final zzrt f4451a;

    public zztu(zzrt zzrtVar) {
        this.f4451a = zzrtVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final zzrt zzqb() {
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final Object zzbn(int i) {
        return this.f4451a.zzbn(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4451a.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final void zzc(zzps zzpsVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new dt(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new du(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final List<?> zzqa() {
        return this.f4451a.zzqa();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f4451a.get(i);
    }
}
