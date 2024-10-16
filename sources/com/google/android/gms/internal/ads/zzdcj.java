package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzdcj {

    @Deprecated
    public static final zzdho zzgpt = (zzdho) ((zzdob) zzdho.zzatk().a(zzddo.zzgpt).zzb(zzdbl.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzgs("TINK_AEAD_1_0_0").zzaya());

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private static final zzdho f3542a = (zzdho) ((zzdob) zzdho.zzatk().a(zzgpt).zzgs("TINK_AEAD_1_1_0").zzaya());
    public static final zzdho zzgpv = (zzdho) ((zzdob) zzdho.zzatk().a(zzddo.zzgpv).zzb(zzdbl.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzb(zzdbl.zza("TinkAead", "Aead", "XChaCha20Poly1305Key", 0, true)).zzgs("TINK_AEAD").zzaya());

    public static void zzany() throws GeneralSecurityException {
        zzddo.zzany();
        zzdcf.zza("TinkAead", new abm());
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
