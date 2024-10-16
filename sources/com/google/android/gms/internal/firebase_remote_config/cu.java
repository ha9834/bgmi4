package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cu implements cv {
    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final Map<?, ?> a(Object obj) {
        return (zzig) obj;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final ct<?, ?> b(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final Map<?, ?> c(Object obj) {
        return (zzig) obj;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final boolean d(Object obj) {
        return !((zzig) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final Object e(Object obj) {
        ((zzig) obj).zzeu();
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final Object f(Object obj) {
        return zzig.zzhv().zzhw();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final Object a(Object obj, Object obj2) {
        zzig zzigVar = (zzig) obj;
        zzig zzigVar2 = (zzig) obj2;
        if (!zzigVar2.isEmpty()) {
            if (!zzigVar.isMutable()) {
                zzigVar = zzigVar.zzhw();
            }
            zzigVar.zza(zzigVar2);
        }
        return zzigVar;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cv
    public final int a(int i, Object obj, Object obj2) {
        zzig zzigVar = (zzig) obj;
        if (zzigVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzigVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
