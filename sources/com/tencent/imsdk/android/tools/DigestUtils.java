package com.tencent.imsdk.android.tools;

import android.util.Base64;
import com.adjust.sdk.Constants;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class DigestUtils {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz8aoT1TUVtZEtpuN4hyT\n6nSXHTljIW+plP87shul1PseGP8iEShO0t59zZUWtrbKi15WrYGpsnDKiw88ch+J\nZVrgjdSomtSQyn9x39Gx/+K1YuWc3Jq54yniPon0tzWqbYHcYer99g3mj6v1vfiZ\nDoXFFfbkkBobXwzz8g1ygWYytOGsEsXRXtGHY4TDtJ3GzaKujb7KWOe32MCD7UkB\nxFtVefw25Mg0rldTrnGGnwPKty1erbKy+Mz/GMVp+HgztuzoqThg8ZjzpQoTxbgD\nIKEMc2i3dZ8gqgKtKKIHnmtMgg/Qqm55nvM7Q76Hk6j6P7SC0FgB/5brWCKHGMGM\n3QIDAQAB";
    private static String mAESSecretKey;
    private static Cipher mPubKCipher;

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            char[] cArr = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                cArr[i] = DIGITS_LOWER[(digest[i2] & 240) >>> 4];
                i = i3 + 1;
                cArr[i3] = DIGITS_LOWER[digest[i2] & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            IMLogger.w("getMD5 parser error " + e.getMessage(), new Object[0]);
            return str;
        }
    }

    public static byte[] decryptRSA(byte[] bArr, String str) throws Exception {
        byte[] decode = Base64.decode(str, 2);
        byte[] decode2 = Base64.decode(bArr, 2);
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePublic);
        return cipher.doFinal(decode2);
    }

    private static void getRsaPubKCipher(String str) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        mPubKCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        mPubKCipher.init(1, generatePublic);
    }

    public static String getAESSecretKey() {
        if (mAESSecretKey == null) {
            mAESSecretKey = UUID.randomUUID().toString().substring(0, 16);
        }
        return mAESSecretKey;
    }

    public static String getAESEncryptKey(String str, String str2) {
        try {
            if (mPubKCipher == null) {
                getRsaPubKCipher(str);
            }
            return new String(Base64.encode(mPubKCipher.doFinal(str2.getBytes(Charset.forName("UTF-8"))), 2), Charset.forName("UTF-8"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
            return null;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String encryptAES(String str, String str2) {
        if (str == null) {
            return str;
        }
        getAESSecretKey();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static String decryptAES(String str, String str2) {
        if (str == null) {
            return str;
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode), Charset.forName("UTF-8"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
