package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class HexUtil {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] emptybytes = new byte[0];

    public static byte char2Byte(char c) {
        if (c >= '0' && c <= '9') {
            return (byte) (c - '0');
        }
        if (c >= 'a' && c <= 'f') {
            return (byte) ((c - 'a') + 10);
        }
        if (c < 'A' || c > 'F') {
            return (byte) 0;
        }
        return (byte) ((c - 'A') + 10);
    }

    public static String byte2HexStr(byte b) {
        char[] cArr = digits;
        return new String(new char[]{cArr[((byte) (b >>> 4)) & 15], cArr[b & 15]});
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = digits;
            cArr[i2 + 1] = cArr2[b & 15];
            cArr[i2 + 0] = cArr2[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }

    public static byte hexStr2Byte(String str) {
        if (str == null || str.length() != 1) {
            return (byte) 0;
        }
        return char2Byte(str.charAt(0));
    }

    public static byte[] hexStr2Bytes(String str) {
        if (str == null || str.equals("")) {
            return emptybytes;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((char2Byte(str.charAt(i2)) * 16) + char2Byte(str.charAt(i2 + 1)));
        }
        return bArr;
    }
}
