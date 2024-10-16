package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import com.google.android.gms.internal.ads.zzdhc;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abl {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f1783a = Charset.forName("UTF-8");

    public static zzdhc a(zzdha zzdhaVar) {
        zzdhc.zza zzev = zzdhc.zzass().zzev(zzdhaVar.zzash());
        for (zzdha.zzb zzbVar : zzdhaVar.zzasi()) {
            zzev.zzb((zzdhc.zzb) ((zzdob) zzdhc.zzb.zzasu().zzgq(zzbVar.zzasn().zzart()).zzc(zzbVar.zzaso()).zzc(zzbVar.zzanw()).zzew(zzbVar.zzasp()).zzaya()));
        }
        return (zzdhc) ((zzdob) zzev.zzaya());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void b(zzdha zzdhaVar) throws GeneralSecurityException {
        int zzash = zzdhaVar.zzash();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzdha.zzb zzbVar : zzdhaVar.zzasi()) {
            if (zzbVar.zzaso() != zzdgu.DESTROYED) {
                i++;
                if (!zzbVar.zzasm()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzasp())));
                }
                if (zzbVar.zzanw() == zzdhm.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzasp())));
                }
                if (zzbVar.zzaso() == zzdgu.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzasp())));
                }
                if (zzbVar.zzaso() == zzdgu.ENABLED && zzbVar.zzasp() == zzash) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzbVar.zzasn().zzarv() != zzdgr.zzb.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
