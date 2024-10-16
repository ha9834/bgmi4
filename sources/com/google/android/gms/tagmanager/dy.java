package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class dy extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5130a = com.google.android.gms.internal.gtm.zza.UPPERCASE_STRING.toString();
    private static final String b = zzb.ARG0.toString();

    public dy() {
        super(f5130a, b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(zzgj.zzc(map.get(b)).toUpperCase());
    }
}
