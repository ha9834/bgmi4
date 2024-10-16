package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzddc {

    @Deprecated
    public static final zzdho zzgpt = (zzdho) ((zzdob) zzdho.zzatk().a(zzdcj.zzgpt).zzb(zzdbl.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdbl.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzgs("TINK_HYBRID_1_0_0").zzaya());

    @Deprecated
    public static final zzdho zzgpu = (zzdho) ((zzdob) zzdho.zzatk().a(zzgpt).zzgs("TINK_HYBRID_1_1_0").zzaya());
    public static final zzdho zzgpv = (zzdho) ((zzdob) zzdho.zzatk().a(zzdcj.zzgpv).zzb(zzdbl.zza("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdbl.zza("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzgs("TINK_HYBRID").zzaya());

    public static void zzany() throws GeneralSecurityException {
        zzdcj.zzany();
        zzdcf.zza("TinkHybridEncrypt", new abz());
        zzdcf.zza("TinkHybridDecrypt", new aby());
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
