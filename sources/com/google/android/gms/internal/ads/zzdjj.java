package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdjj implements zzdlk {

    /* renamed from: a, reason: collision with root package name */
    private final SecretKeySpec f3561a;
    private final int b;
    private final int c;

    public zzdjj(byte[] bArr, int i) throws GeneralSecurityException {
        zzdlx.zzfg(bArr.length);
        this.f3561a = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        this.c = zzdkx.zzhap.zzgt("AES/CTR/NoPadding").getBlockSize();
        if (i < 12 || i > this.c) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.b = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.b;
        if (length > Integer.MAX_VALUE - i) {
            int i2 = Integer.MAX_VALUE - i;
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i2);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] zzff = zzdlo.zzff(i);
        System.arraycopy(zzff, 0, bArr2, 0, this.b);
        int length2 = bArr.length;
        int i3 = this.b;
        Cipher zzgt = zzdkx.zzhap.zzgt("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.c];
        System.arraycopy(zzff, 0, bArr3, 0, this.b);
        zzgt.init(1, this.f3561a, new IvParameterSpec(bArr3));
        if (zzgt.doFinal(bArr, 0, length2, bArr2, i3) == length2) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
