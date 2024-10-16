package com.tencent.mid.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static RSAPublicKey f6276a;

    public static void a(String str) {
        try {
            f6276a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(byte[] bArr) {
        byte[] doFinal;
        if (f6276a == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1PADDING");
        cipher.init(1, f6276a);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    doFinal = cipher.doFinal(bArr, i, 117);
                } else {
                    doFinal = cipher.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String b(byte[] bArr) {
        if (f6276a == null) {
            throw new Exception("解密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1PADDING");
            cipher.init(2, f6276a);
            int bitLength = f6276a.getModulus().bitLength() / 8;
            String str = "";
            if (bitLength > 0) {
                for (byte[] bArr2 : a(bArr, bitLength)) {
                    str = str + new String(cipher.doFinal(bArr2), "UTF-8");
                }
            }
            return str;
        } catch (InvalidKeyException unused) {
            throw new Exception("解密私钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此解密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("密文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("密文长度非法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception unused5) {
            throw new Exception("发生未知异常");
        }
    }

    public static byte[][] a(byte[] bArr, int i) {
        int length = bArr.length / i;
        int length2 = bArr.length % i;
        int i2 = length + (length2 != 0 ? 1 : 0);
        byte[][] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr3 = new byte[i];
            if (i3 == i2 - 1 && length2 != 0) {
                System.arraycopy(bArr, i3 * i, bArr3, 0, length2);
            } else {
                System.arraycopy(bArr, i3 * i, bArr3, 0, i);
            }
            bArr2[i3] = bArr3;
        }
        return bArr2;
    }
}
