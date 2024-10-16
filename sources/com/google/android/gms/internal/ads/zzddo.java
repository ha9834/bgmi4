package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzddo {

    @Deprecated
    public static final zzdho zzgpt = (zzdho) ((zzdob) zzdho.zzatk().zzgs("TINK_MAC_1_0_0").zzb(zzdbl.zza("TinkMac", "Mac", "HmacKey", 0, true)).zzaya());

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private static final zzdho f3549a = (zzdho) ((zzdob) zzdho.zzatk().a(zzgpt).zzgs("TINK_MAC_1_1_0").zzaya());
    public static final zzdho zzgpv = (zzdho) ((zzdob) zzdho.zzatk().a(zzgpt).zzgs("TINK_MAC").zzaya());

    public static void zzany() throws GeneralSecurityException {
        zzdcf.zza("TinkMac", new acg());
        zzdbl.zza(zzgpv);
    }

    static {
        try {
            zzany();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
