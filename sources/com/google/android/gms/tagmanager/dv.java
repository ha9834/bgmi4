package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class dv extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5129a = com.google.android.gms.internal.gtm.zza.TIME.toString();

    public dv() {
        super(f5129a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Long.valueOf(System.currentTimeMillis()));
    }
}
