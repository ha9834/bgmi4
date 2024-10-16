package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cm implements cl {
    @Override // com.google.android.gms.internal.gtm.cl
    public final Map<?, ?> a(Object obj) {
        return (zzse) obj;
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final ck<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final Map<?, ?> b(Object obj) {
        return (zzse) obj;
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final boolean c(Object obj) {
        return !((zzse) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final Object d(Object obj) {
        ((zzse) obj).zzmi();
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final Object e(Object obj) {
        return zzse.zzqf().zzqg();
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final Object a(Object obj, Object obj2) {
        zzse zzseVar = (zzse) obj;
        zzse zzseVar2 = (zzse) obj2;
        if (!zzseVar2.isEmpty()) {
            if (!zzseVar.isMutable()) {
                zzseVar = zzseVar.zzqg();
            }
            zzseVar.zza(zzseVar2);
        }
        return zzseVar;
    }

    @Override // com.google.android.gms.internal.gtm.cl
    public final int a(int i, Object obj, Object obj2) {
        zzse zzseVar = (zzse) obj;
        if (zzseVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzseVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
