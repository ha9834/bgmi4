package com.tdatamaster.tdm.Utils;

/* loaded from: classes2.dex */
public class Base64Util {
    private static final char last2byte = (char) Integer.parseInt("00000011", 2);
    private static final char last4byte = (char) Integer.parseInt("00001111", 2);
    private static final char last6byte = (char) Integer.parseInt("00111111", 2);
    private static final char lead6byte = (char) Integer.parseInt("11111100", 2);
    private static final char lead4byte = (char) Integer.parseInt("11110000", 2);
    private static final char lead2byte = (char) Integer.parseInt("11000000", 2);
    private static final char[] encodeTable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String encode(byte[] bArr) {
        double length = bArr.length;
        Double.isNaN(length);
        StringBuffer stringBuffer = new StringBuffer(((int) (length * 1.34d)) + 3);
        int i = 0;
        char c = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i %= 8;
            while (i < 8) {
                if (i == 0) {
                    c = (char) (((char) (bArr[i2] & lead6byte)) >>> 2);
                } else if (i == 2) {
                    c = (char) (bArr[i2] & last6byte);
                } else if (i == 4) {
                    c = (char) (((char) (bArr[i2] & last4byte)) << 2);
                    int i3 = i2 + 1;
                    if (i3 < bArr.length) {
                        c = (char) (c | ((bArr[i3] & lead2byte) >>> 6));
                    }
                } else if (i == 6) {
                    c = (char) (((char) (bArr[i2] & last2byte)) << 4);
                    int i4 = i2 + 1;
                    if (i4 < bArr.length) {
                        c = (char) (c | ((bArr[i4] & lead4byte) >>> 4));
                    }
                }
                stringBuffer.append(encodeTable[c]);
                i += 6;
            }
        }
        if (stringBuffer.length() % 4 != 0) {
            for (int length2 = 4 - (stringBuffer.length() % 4); length2 > 0; length2--) {
                stringBuffer.append("=");
            }
        }
        return stringBuffer.toString();
    }
}
