package com.google.android.vending.licensing;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class a implements h {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f5381a = {16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};
    private Cipher b;
    private Cipher c;

    public a(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC").generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, 256)).getEncoded(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            this.b = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            this.b.init(1, secretKeySpec, new IvParameterSpec(f5381a));
            this.c = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            this.c.init(2, secretKeySpec, new IvParameterSpec(f5381a));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Invalid environment", e);
        }
    }

    @Override // com.google.android.vending.licensing.h
    public String a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return com.google.android.vending.licensing.util.a.a(this.b.doFinal(("com.google.android.vending.licensing.AESObfuscator-1|" + str2 + str).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Invalid environment", e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    @Override // com.google.android.vending.licensing.h
    public String b(String str, String str2) throws ValidationException {
        if (str == null) {
            return null;
        }
        try {
            String str3 = new String(this.c.doFinal(com.google.android.vending.licensing.util.a.a(str)), "UTF-8");
            if (str3.indexOf("com.google.android.vending.licensing.AESObfuscator-1|" + str2) != 0) {
                throw new ValidationException("Header not found (invalid data or key):" + str);
            }
            return str3.substring(53 + str2.length(), str3.length());
        } catch (Base64DecoderException e) {
            throw new ValidationException(e.getMessage() + CertificateUtil.DELIMITER + str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Invalid environment", e2);
        } catch (BadPaddingException e3) {
            throw new ValidationException(e3.getMessage() + CertificateUtil.DELIMITER + str);
        } catch (IllegalBlockSizeException e4) {
            throw new ValidationException(e4.getMessage() + CertificateUtil.DELIMITER + str);
        }
    }
}
