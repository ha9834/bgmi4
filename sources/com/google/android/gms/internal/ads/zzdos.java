package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzdos extends aem<String> implements zzdot, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final zzdos f3596a;
    private static final zzdot b;
    private final List<Object> c;

    public zzdos() {
        this(10);
    }

    public zzdos(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzdos(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof zzdot) {
            collection = ((zzdot) collection).zzayo();
        }
        boolean addAll = this.c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final void zzdb(zzdmr zzdmrVar) {
        a();
        this.c.add(zzdmrVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final Object zzgq(int i) {
        return this.c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            return ((zzdmr) obj).zzavn();
        }
        return zzdod.zzae((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final List<?> zzayo() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzdot
    public final zzdot zzayp() {
        return zzavi() ? new zzdqw(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        a();
        return a(this.c.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.c.remove(i);
        this.modCount++;
        return a(remove);
    }

    @Override // com.google.android.gms.internal.ads.aem, com.google.android.gms.internal.ads.zzdoj
    public final /* bridge */ /* synthetic */ boolean zzavi() {
        return super.zzavi();
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj zzfl(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new zzdos((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdmr) {
            zzdmr zzdmrVar = (zzdmr) obj;
            String zzavn = zzdmrVar.zzavn();
            if (zzdmrVar.zzavo()) {
                this.c.set(i, zzavn);
            }
            return zzavn;
        }
        byte[] bArr = (byte[]) obj;
        String zzae = zzdod.zzae(bArr);
        if (zzdod.zzad(bArr)) {
            this.c.set(i, zzae);
        }
        return zzae;
    }

    static {
        zzdos zzdosVar = new zzdos();
        f3596a = zzdosVar;
        zzdosVar.zzavj();
        b = f3596a;
    }
}
