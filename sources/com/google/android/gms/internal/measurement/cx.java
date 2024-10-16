package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cx implements cv {
    @Override // com.google.android.gms.internal.measurement.cv
    public final Map<?, ?> a(Object obj) {
        return (zzgc) obj;
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final cu<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final Map<?, ?> b(Object obj) {
        return (zzgc) obj;
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final boolean c(Object obj) {
        return !((zzgc) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final Object d(Object obj) {
        ((zzgc) obj).zzry();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final Object e(Object obj) {
        return zzgc.zzvl().zzvm();
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final Object a(Object obj, Object obj2) {
        zzgc zzgcVar = (zzgc) obj;
        zzgc zzgcVar2 = (zzgc) obj2;
        if (!zzgcVar2.isEmpty()) {
            if (!zzgcVar.isMutable()) {
                zzgcVar = zzgcVar.zzvm();
            }
            zzgcVar.zza(zzgcVar2);
        }
        return zzgcVar;
    }

    @Override // com.google.android.gms.internal.measurement.cv
    public final int a(int i, Object obj, Object obj2) {
        zzgc zzgcVar = (zzgc) obj;
        if (zzgcVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgcVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
