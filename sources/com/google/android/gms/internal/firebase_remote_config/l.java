package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractMap;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends AbstractMap<String, Object> {

    /* renamed from: a, reason: collision with root package name */
    final Object f4101a;
    final zzbr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Object obj, boolean z) {
        this.f4101a = obj;
        this.b = zzbr.zza(obj.getClass(), z);
        if (!(!this.b.isEnum())) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzbz zzae;
        if ((obj instanceof String) && (zzae = this.b.zzae((String) obj)) != null) {
            return zzae.zzh(this.f4101a);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Set entrySet() {
        return new o(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object put(Object obj, Object obj2) {
        String str = (String) obj;
        zzbz zzae = this.b.zzae(str);
        String valueOf = String.valueOf(str);
        String concat = valueOf.length() != 0 ? "no field of key ".concat(valueOf) : new String("no field of key ");
        if (zzae == null) {
            throw new NullPointerException(String.valueOf(concat));
        }
        Object zzh = zzae.zzh(this.f4101a);
        zzae.zzb(this.f4101a, zzdt.checkNotNull(obj2));
        return zzh;
    }
}
