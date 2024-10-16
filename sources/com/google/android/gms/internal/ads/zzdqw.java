package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzdqw extends AbstractList<String> implements zzdot, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final zzdot f3599a;

    public zzdqw(zzdot zzdotVar) {
        this.f3599a = zzdotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final zzdot zzayp() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final Object zzgq(int i) {
        return this.f3599a.zzgq(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3599a.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final void zzdb(zzdmr zzdmrVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new ahq(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new ahr(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final List<?> zzayo() {
        return this.f3599a.zzayo();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f3599a.get(i);
    }
}
