package com.tencent.mid.util;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final List<Integer> f6270a = new ArrayList(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, Integer.valueOf(ProgressEvent.PART_COMPLETED_EVENT_CODE)));
    private SecretKey b = null;
    private IvParameterSpec c = null;

    public static SecretKey a() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            keyGenerator.init(128);
            return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public byte[] b() {
        SecretKey secretKey = this.b;
        if (secretKey != null) {
            return secretKey.getEncoded();
        }
        return null;
    }

    public byte[] c() {
        IvParameterSpec ivParameterSpec = this.c;
        if (ivParameterSpec != null) {
            return ivParameterSpec.getIV();
        }
        return null;
    }

    public static IvParameterSpec d() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return new IvParameterSpec(bArr);
    }

    public void e() {
        this.b = a();
        this.c = d();
    }

    private int a(int i, int i2) {
        if (i < i2) {
            i = i2;
        }
        if (!f6270a.contains(Integer.valueOf(i))) {
            for (Integer num : f6270a) {
                if (num.intValue() > i) {
                    return num.intValue();
                }
            }
        }
        return i;
    }

    private byte[] a(String str, int i) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length >= i) {
            return bytes;
        }
        byte[] bArr = new byte[i];
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, length);
        return bArr;
    }

    public void a(String str, String str2) {
        int a2 = a(str.length(), str2.length());
        byte[] a3 = a(str, a2);
        byte[] a4 = a(str2, a2);
        this.b = new SecretKeySpec(a3, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        this.c = new IvParameterSpec(a4);
    }

    public byte[] a(byte[] bArr) {
        if (this.b == null) {
            throw new Exception("密钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(1, this.b, this.c);
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] b(byte[] bArr) {
        if (this.b == null) {
            throw new Exception("密钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(2, this.b, this.c);
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
