package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
final class acb {
    public static void a(zzdft zzdftVar) throws GeneralSecurityException {
        zzdkr.zza(a(zzdftVar.zzaqp().zzara()));
        a(zzdftVar.zzaqp().zzaoo());
        if (zzdftVar.zzaqr() == zzdfd.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzdcf.zza(zzdftVar.zzaqq().zzaqk());
    }

    public static String a(zzdgj zzdgjVar) throws NoSuchAlgorithmException {
        switch (acc.f1786a[zzdgjVar.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzdgjVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
        }
    }

    public static zzdkt a(zzdgf zzdgfVar) throws GeneralSecurityException {
        switch (acc.b[zzdgfVar.ordinal()]) {
            case 1:
                return zzdkt.NIST_P256;
            case 2:
                return zzdkt.NIST_P384;
            case 3:
                return zzdkt.NIST_P521;
            default:
                String valueOf = String.valueOf(zzdgfVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static zzdkv a(zzdfd zzdfdVar) throws GeneralSecurityException {
        switch (acc.c[zzdfdVar.ordinal()]) {
            case 1:
                return zzdkv.UNCOMPRESSED;
            case 2:
                return zzdkv.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            case 3:
                return zzdkv.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzdfdVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }
}
