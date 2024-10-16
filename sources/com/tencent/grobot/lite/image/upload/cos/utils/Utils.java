package com.tencent.grobot.lite.image.upload.cos.utils;

import com.adjust.sdk.Constants;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class Utils {
    private static final char[] DIGITS_LOWER;
    private static final char[] DIGITS_UPPER;
    private static Calendar calendar = Calendar.getInstance();

    static {
        calendar.set(2010, 0, 1);
        DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    static long handleTimeAccuracy(long j) {
        return j > calendar.getTime().getTime() ? j / 1000 : j;
    }

    public static byte[] decodeHex(String str) {
        return decodeHex(str.toCharArray());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decodeHex(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int digit = toDigit(cArr[i], i) << 4;
            int i3 = i + 1;
            int digit2 = digit | toDigit(cArr[i3], i3);
            i = i3 + 1;
            bArr[i2] = (byte) (digit2 & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    public static String encodeHexString(byte[] bArr, boolean z) {
        return new String(encodeHex(bArr, z));
    }

    public static byte[] sha1(String str) {
        try {
            return MessageDigest.getInstance(Constants.SHA1).digest(StringUtils.getBytesUTF8(str));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] hmacSha1(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(StringUtils.getBytesUTF8(str2), com.amazonaws.services.s3.internal.Constants.HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(com.amazonaws.services.s3.internal.Constants.HMAC_SHA1_ALGORITHM);
            mac.init(secretKeySpec);
            return mac.doFinal(StringUtils.getBytesUTF8(str));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    static int toDigit(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character " + c + " at index " + i);
    }

    static long[] parseKeyTimes(String str) {
        String[] split = str.split(";");
        return new long[]{Long.parseLong(split[0]), Long.parseLong(split[1])};
    }
}
