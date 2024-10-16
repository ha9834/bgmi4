package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class agg implements agf {
    @Override // com.google.android.gms.internal.ads.agf
    public final Map<?, ?> a(Object obj) {
        return (zzdpe) obj;
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final age<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final Map<?, ?> b(Object obj) {
        return (zzdpe) obj;
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final boolean c(Object obj) {
        return !((zzdpe) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final Object d(Object obj) {
        ((zzdpe) obj).zzavj();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final Object e(Object obj) {
        return zzdpe.zzayt().zzayu();
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final Object a(Object obj, Object obj2) {
        zzdpe zzdpeVar = (zzdpe) obj;
        zzdpe zzdpeVar2 = (zzdpe) obj2;
        if (!zzdpeVar2.isEmpty()) {
            if (!zzdpeVar.isMutable()) {
                zzdpeVar = zzdpeVar.zzayu();
            }
            zzdpeVar.zza(zzdpeVar2);
        }
        return zzdpeVar;
    }

    @Override // com.google.android.gms.internal.ads.agf
    public final int a(int i, Object obj, Object obj2) {
        zzdpe zzdpeVar = (zzdpe) obj;
        if (zzdpeVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzdpeVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
