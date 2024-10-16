package com.tencent.gsdk.utils;

import android.annotation.SuppressLint;
import com.tencent.mtt.engine.http.HttpUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected static final char[] f6244a = "0123456789abcdef".toCharArray();
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @SuppressLint({"TrulyRandom"})
    public static String a(String str, String str2) {
        byte[] bArr = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HttpUtils.DEFAULT_ENCODE_NAME), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            if (str != null) {
                bArr = cipher.doFinal(str.getBytes(HttpUtils.DEFAULT_ENCODE_NAME));
            }
        } catch (Exception e) {
            g.c("HttpDnsUtils encrypt error:" + e.getMessage());
        }
        return a(bArr);
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HttpUtils.DEFAULT_ENCODE_NAME), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            byte[] doFinal = cipher.doFinal(a(str));
            return doFinal != null ? new String(doFinal) : "";
        } catch (Exception e) {
            g.c("HttpDnsUtils decrypt error:" + e.getMessage());
            return "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = b;
            cArr[i2 + 1] = cArr2[b2 & 15];
            cArr[i2 + 0] = cArr2[((byte) (b2 >>> 4)) & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
