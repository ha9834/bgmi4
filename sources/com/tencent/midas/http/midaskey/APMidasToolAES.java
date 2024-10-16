package com.tencent.midas.http.midaskey;

import android.text.TextUtils;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.midas.http.core.HttpLog;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class APMidasToolAES {
    public static String doEncode(String str, String str2) {
        return encryptAES(str, str2);
    }

    public static String doDecode(String str, String str2) {
        return decryptAES(parseHexStr2Byte(str), str2);
    }

    public static String encryptAES(String str, String str2, String str3) {
        byte[] bArr = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            if (!TextUtils.isEmpty(str3) && str3.length() >= 16) {
                cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes()));
                bArr = cipher.doFinal(str.getBytes());
            }
        } catch (Exception e) {
            HttpLog.w("encryptAESTools", String.valueOf(e));
        }
        return bArr != null ? parseByte2HexStr(bArr) : str;
    }

    public static String encryptAES(String str, String str2) {
        byte[] bArr = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            if (!TextUtils.isEmpty("1234567890123456")) {
                cipher.init(1, secretKeySpec, new IvParameterSpec("1234567890123456".substring(0, 16).getBytes()));
                bArr = cipher.doFinal(str.getBytes());
            }
        } catch (Exception e) {
            HttpLog.w("encryptAESTools", String.valueOf(e));
        }
        return bArr != null ? parseByte2HexStr(bArr) : str;
    }

    public static String decryptAES(byte[] bArr, String str) {
        byte[] bArr2;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(2, secretKeySpec, new IvParameterSpec("1234567890123456".getBytes()));
            bArr2 = cipher.doFinal(bArr);
        } catch (Exception e) {
            HttpLog.w("decryptAESTools", String.valueOf(e));
            bArr2 = null;
        }
        return bArr2 != null ? new String(bArr2) : "";
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
