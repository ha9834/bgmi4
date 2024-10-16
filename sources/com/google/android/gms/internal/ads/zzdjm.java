package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdjm implements zzdbj {

    /* renamed from: a, reason: collision with root package name */
    private final SecretKey f3563a;

    public zzdjm(byte[] bArr) throws GeneralSecurityException {
        zzdlx.zzfg(bArr.length);
        this.f3563a = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] zzff = zzdlo.zzff(12);
        System.arraycopy(zzff, 0, bArr3, 0, 12);
        Cipher zzgt = zzdkx.zzhap.zzgt("AES/GCM/NoPadding");
        zzgt.init(1, this.f3563a, a(zzff, 0, zzff.length));
        if (bArr2 != null && bArr2.length != 0) {
            zzgt.updateAAD(bArr2);
        }
        int doFinal = zzgt.doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (doFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - bArr.length)));
    }

    private static AlgorithmParameterSpec a(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (zzdlv.zzavd()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }
}
