package com.tencent.midas.oversea.comm;

import com.adjust.sdk.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class APMD5 {
    public static String toMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            return parseByte2HexStr(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
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
}
