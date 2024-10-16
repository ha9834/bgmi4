package com.google.android.gms.internal.ads;

import com.adjust.sdk.Constants;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzdlv {
    public static String zza(zzdlg zzdlgVar) throws GeneralSecurityException {
        zzdlx.zzc(zzdlgVar);
        String valueOf = String.valueOf(zzdlgVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
        sb.append(valueOf);
        sb.append("withECDSA");
        return sb.toString();
    }

    public static String zzb(zzdlg zzdlgVar) throws GeneralSecurityException {
        switch (aed.f1826a[zzdlgVar.ordinal()]) {
            case 1:
                return Constants.SHA1;
            case 2:
                return Constants.SHA256;
            case 3:
                return "SHA-512";
            default:
                String valueOf = String.valueOf(zzdlgVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
                sb.append("Unsupported hash ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static boolean zzavd() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static BigInteger zzx(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] zza(BigInteger bigInteger, int i) throws GeneralSecurityException {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i) {
            return byteArray;
        }
        int i2 = i + 1;
        if (byteArray.length > i2) {
            throw new GeneralSecurityException("integer too large");
        }
        if (byteArray.length == i2) {
            if (byteArray[0] == 0) {
                return Arrays.copyOfRange(byteArray, 1, byteArray.length);
            }
            throw new GeneralSecurityException("integer too large");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(byteArray, 0, bArr, i - byteArray.length, byteArray.length);
        return bArr;
    }

    public static byte[] zza(byte[] bArr, int i, zzdlg zzdlgVar) throws GeneralSecurityException {
        MessageDigest zzgt = zzdkx.zzhas.zzgt(zzb(zzdlgVar));
        int digestLength = zzgt.getDigestLength();
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 <= (i - 1) / digestLength; i3++) {
            zzgt.reset();
            zzgt.update(bArr);
            zzgt.update(zza(BigInteger.valueOf(i3), 4));
            byte[] digest = zzgt.digest();
            System.arraycopy(digest, 0, bArr2, i2, Math.min(digest.length, bArr2.length - i2));
            i2 += digest.length;
        }
        return bArr2;
    }
}
