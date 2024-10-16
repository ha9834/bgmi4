package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class ek extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5139a = com.google.android.gms.internal.gtm.zza.CONSTANT.toString();
    private static final String b = zzb.VALUE.toString();

    public static String a() {
        return f5139a;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    public ek() {
        super(f5139a, b);
    }

    public static String b() {
        return b;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return map.get(b);
    }
}
