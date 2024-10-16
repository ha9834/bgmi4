package com.tencent.gsdk.utils;

import android.annotation.SuppressLint;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f6235a = "ToBeOrNot0123456";
    private static String b = "1234567812345678";

    @SuppressLint({"TrulyRandom"})
    public static String a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            cipher.init(1, new SecretKeySpec(f6235a.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(b.getBytes()));
            return b.a(cipher.doFinal(bArr));
        } catch (Exception e) {
            g.c("AesUtils encrypt error:" + e.getMessage());
            return null;
        }
    }

    public static String b(String str) {
        try {
            byte[] a2 = b.a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(f6235a.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(b.getBytes()));
            byte[] doFinal = cipher.doFinal(a2);
            int i = 0;
            while (i < doFinal.length && doFinal[(doFinal.length - 1) - i] == 0) {
                i++;
            }
            return new String(doFinal, 0, doFinal.length - i);
        } catch (Exception e) {
            g.c("AesUtils decrypt error:" + e.getMessage());
            return null;
        }
    }
}
