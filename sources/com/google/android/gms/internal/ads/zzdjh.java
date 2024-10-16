package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdjh implements zzdby {

    /* renamed from: a, reason: collision with root package name */
    private final SecretKey f3560a;
    private final int b;
    private byte[] c;
    private byte[] d;

    private static Cipher a() throws GeneralSecurityException {
        return zzdkx.zzhap.zzgt("AES/ECB/NoPadding");
    }

    public zzdjh(byte[] bArr, int i) throws GeneralSecurityException {
        zzdlx.zzfg(bArr.length);
        this.f3560a = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        this.b = 16;
        Cipher a2 = a();
        a2.init(1, this.f3560a);
        this.c = adu.a(a2.doFinal(new byte[16]));
        this.d = adu.a(this.c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzdby
    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        byte[] zzd;
        Cipher a2 = a();
        a2.init(1, this.f3560a);
        double length = bArr.length;
        Double.isNaN(length);
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if ((max << 4) == bArr.length) {
            zzd = zzdjs.zza(bArr, (max - 1) << 4, this.c, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
            copyOf[copyOfRange.length] = Byte.MIN_VALUE;
            zzd = zzdjs.zzd(copyOf, this.d);
        }
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr2 = a2.doFinal(zzdjs.zza(bArr2, 0, bArr, i << 4, 16));
        }
        byte[] zzd2 = zzdjs.zzd(zzd, bArr2);
        byte[] bArr3 = new byte[this.b];
        System.arraycopy(a2.doFinal(zzd2), 0, bArr3, 0, this.b);
        return bArr3;
    }
}
