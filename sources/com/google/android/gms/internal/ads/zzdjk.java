package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.intlgame.core.INTLMethodID;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdjk implements zzdbj {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3562a;
    private final byte[] b;
    private final SecretKeySpec c;
    private final int d;

    public zzdjk(byte[] bArr, int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.d = i;
        zzdlx.zzfg(bArr.length);
        this.c = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.c);
        this.f3562a = a(cipher.doFinal(new byte[16]));
        this.b = a(this.f3562a);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? INTLMethodID.INTL_METHOD_ID_AUTH_MODIFY_DATA_PROTECTION_ACCEPTANCE : 0));
        return bArr2;
    }

    private final byte[] a(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(a(bArr3, this.f3562a));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        byte[] bArr4 = doFinal;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArr4 = cipher.doFinal(bArr4);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = a(copyOfRange, this.f3562a);
        } else {
            byte[] copyOf = Arrays.copyOf(this.b, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(a(bArr4, bArr2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        if (length > (Integer.MAX_VALUE - i) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] zzff = zzdlo.zzff(i);
        System.arraycopy(zzff, 0, bArr3, 0, this.d);
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.c);
        byte[] a2 = a(cipher, 0, zzff, 0, zzff.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] a3 = a(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher2.init(1, this.c, new IvParameterSpec(a2));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.d);
        byte[] a4 = a(cipher, 2, bArr3, this.d, bArr.length);
        int length2 = bArr.length + this.d;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[length2 + i2] = (byte) ((a3[i2] ^ a2[i2]) ^ a4[i2]);
        }
        return bArr3;
    }
}
