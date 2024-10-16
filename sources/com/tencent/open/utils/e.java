package com.tencent.open.utils;

import android.util.Base64;
import com.adjust.sdk.Constants;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.tencent.open.log.SLog;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6402a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            SLog.e("DESUtils", "encryptAES", e);
            return null;
        }
    }

    public static byte[] a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception e) {
            SLog.e("DESUtils", "encryptSha", e);
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f6402a;
            cArr[i2 + 1] = cArr2[b & 15];
            cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
