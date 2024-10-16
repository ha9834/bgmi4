package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzhu extends AbstractList<String> implements zzfp, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final zzfp f4569a;

    public zzhu(zzfp zzfpVar) {
        this.f4569a = zzfpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final zzfp zzvg() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final Object zzbw(int i) {
        return this.f4569a.zzbw(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4569a.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final void zzc(zzdp zzdpVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new ef(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new eh(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final List<?> zzvf() {
        return this.f4569a.zzvf();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f4569a.get(i);
    }
}
