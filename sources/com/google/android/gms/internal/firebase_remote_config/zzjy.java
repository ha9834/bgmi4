package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzjy extends AbstractList<String> implements zzhx, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final zzhx f4191a;

    public zzjy(zzhx zzhxVar) {
        this.f4191a = zzhxVar;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final zzhx zzhr() {
        return this;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final Object zzbd(int i) {
        return this.f4191a.zzbd(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4191a.size();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final void zzd(zzfx zzfxVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new ef(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new ee(this);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final List<?> zzhq() {
        return this.f4191a.zzhq();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f4191a.get(i);
    }
}
