package com.tencent.midas.oversea.comm;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.midas.comm.APLog;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class APToolAES {
    public static String doEncode(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (sb.length() % 16 != 0) {
            sb.append(AnalyticsEventKey.ACTION_SHA);
        }
        return encryptAES(sb.toString(), str2);
    }

    public static String doDecode(String str, String str2) {
        return decryptAES(parseHexStr2Byte(str), str2);
    }

    public static String doDecode(String str, String str2, int i) {
        byte[] parseHexStr2Byte = parseHexStr2Byte(str);
        return parseHexStr2Byte == null ? "" : decryptAES(parseHexStr2Byte, str2);
    }

    public static String encryptAES(String str, String str2) {
        byte[] bArr;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(1, secretKeySpec);
            bArr = cipher.doFinal(str.getBytes());
        } catch (Exception e) {
            APLog.w("encryptAESTools", String.valueOf(e));
            bArr = null;
        }
        return bArr != null ? new String(parseByte2HexStr(bArr)) : str;
    }

    public static String decryptDES(byte[] bArr, String str) {
        byte[] bArr2;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            bArr2 = cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            bArr2 = null;
        }
        return bArr2 != null ? new String(bArr2) : "";
    }

    private static String decryptAES(byte[] bArr, String str) {
        byte[] bArr2;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(2, secretKeySpec, new IvParameterSpec("1234567890123456".getBytes()));
            bArr2 = cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            bArr2 = null;
        }
        return bArr2 != null ? new String(bArr2) : "";
    }

    public static byte[] decryptAES2(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }

    public static String decPress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 5; i < bArr.length; i++) {
            byte b = (byte) ((bArr[i] >> 4) & 15);
            byte b2 = (byte) (bArr[i] & 15);
            sb.append((int) b);
            sb.append((int) b2);
        }
        return sb.toString();
    }
}
