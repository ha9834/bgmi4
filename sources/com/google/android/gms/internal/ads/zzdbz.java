package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes2.dex */
public final class zzdbz {
    @Deprecated
    public static final zzdbu zzl(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdha zzn = zzdha.zzn(bArr);
            a(zzn);
            return zzdbu.a(zzn);
        } catch (zzdok unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final zzdbu zza(zzdbv zzdbvVar) throws GeneralSecurityException, IOException {
        zzdha zzanq = zzdbvVar.zzanq();
        a(zzanq);
        return zzdbu.a(zzanq);
    }

    private static void a(zzdha zzdhaVar) throws GeneralSecurityException {
        for (zzdha.zzb zzbVar : zzdhaVar.zzasi()) {
            if (zzbVar.zzasn().zzarv() == zzdgr.zzb.UNKNOWN_KEYMATERIAL || zzbVar.zzasn().zzarv() == zzdgr.zzb.SYMMETRIC || zzbVar.zzasn().zzarv() == zzdgr.zzb.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}
