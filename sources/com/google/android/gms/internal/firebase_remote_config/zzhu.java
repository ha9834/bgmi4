package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzhu extends bc<String> implements zzhx, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final zzhu f4186a;
    private static final zzhx b;
    private final List<Object> c;

    public zzhu() {
        this(10);
    }

    public zzhu(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzhu(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c.size();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof zzhx) {
            collection = ((zzhx) collection).zzhq();
        }
        boolean addAll = this.c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final void zzd(zzfx zzfxVar) {
        a();
        this.c.add(zzfxVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final Object zzbd(int i) {
        return this.c.get(i);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfx) {
            return ((zzfx) obj).zzb(zzhi.f4184a);
        }
        return zzhi.zzf((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final List<?> zzhq() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhx
    public final zzhx zzhr() {
        return zzet() ? new zzjy(this) : this;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        a();
        return a(this.c.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.c.remove(i);
        this.modCount++;
        return a(remove);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, com.google.android.gms.internal.firebase_remote_config.zzhn
    public final /* bridge */ /* synthetic */ boolean zzet() {
        return super.zzet();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.bc, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzhn
    public final /* synthetic */ zzhn zzu(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new zzhu((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfx) {
            zzfx zzfxVar = (zzfx) obj;
            String zzb = zzfxVar.zzb(zzhi.f4184a);
            if (zzfxVar.zzew()) {
                this.c.set(i, zzb);
            }
            return zzb;
        }
        byte[] bArr = (byte[]) obj;
        String zzf = zzhi.zzf(bArr);
        if (zzhi.zze(bArr)) {
            this.c.set(i, zzf);
        }
        return zzf;
    }

    static {
        zzhu zzhuVar = new zzhu();
        f4186a = zzhuVar;
        zzhuVar.zzeu();
        b = f4186a;
    }
}
