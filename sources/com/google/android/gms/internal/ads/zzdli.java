package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdli {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decode(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(str.charAt(i2), 16);
            int digit2 = Character.digit(str.charAt(i2 + 1), 16);
            if (digit == -1 || digit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i] = (byte) ((digit << 4) + digit2);
        }
        return bArr;
    }
}
