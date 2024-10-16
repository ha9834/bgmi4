package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends AbstractSet<Map.Entry<String, Object>> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ l f4104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.f4104a = lVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator<String> it = this.f4104a.b.f4136a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.f4104a.b.zzae(it.next()).zzh(this.f4104a.f4101a) != null) {
                i++;
            }
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Iterator<String> it = this.f4104a.b.f4136a.iterator();
        while (it.hasNext()) {
            this.f4104a.b.zzae(it.next()).zzb(this.f4104a.f4101a, null);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        Iterator<String> it = this.f4104a.b.f4136a.iterator();
        while (it.hasNext()) {
            if (this.f4104a.b.zzae(it.next()).zzh(this.f4104a.f4101a) != null) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new m(this.f4104a);
    }
}
