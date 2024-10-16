package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzfq extends bg<String> implements zzfp, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final zzfq f4565a;
    private static final zzfp b;
    private final List<Object> c;

    public zzfq() {
        this(10);
    }

    public zzfq(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzfq(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof zzfp) {
            collection = ((zzfp) collection).zzvf();
        }
        boolean addAll = this.c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final void zzc(zzdp zzdpVar) {
        a();
        this.c.add(zzdpVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final Object zzbw(int i) {
        return this.c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdp) {
            return ((zzdp) obj).zzsa();
        }
        return zzez.zzi((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final List<?> zzvf() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.android.gms.internal.measurement.zzfp
    public final zzfp zzvg() {
        return zzrx() ? new zzhu(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        a();
        return a(this.c.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.c.remove(i);
        this.modCount++;
        return a(remove);
    }

    @Override // com.google.android.gms.internal.measurement.bg, com.google.android.gms.internal.measurement.zzff
    public final /* bridge */ /* synthetic */ boolean zzrx() {
        return super.zzrx();
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzff
    public final /* synthetic */ zzff zzap(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new zzfq((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdp) {
            zzdp zzdpVar = (zzdp) obj;
            String zzsa = zzdpVar.zzsa();
            if (zzdpVar.zzsb()) {
                this.c.set(i, zzsa);
            }
            return zzsa;
        }
        byte[] bArr = (byte[]) obj;
        String zzi = zzez.zzi(bArr);
        if (zzez.zzh(bArr)) {
            this.c.set(i, zzi);
        }
        return zzi;
    }

    static {
        zzfq zzfqVar = new zzfq();
        f4565a = zzfqVar;
        zzfqVar.zzry();
        b = f4565a;
    }
}
