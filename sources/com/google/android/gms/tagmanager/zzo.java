package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.tencent.bigdata.dataacquisition.DeviceInfos;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzo {
    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            if ((b & 240) == 0) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
        }
        return sb.toString().toUpperCase();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("purported base16 string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            int digit = Character.digit(str.charAt(i), 16);
            int digit2 = Character.digit(str.charAt(i + 1), 16);
            if (digit == -1 || digit2 == -1) {
                throw new IllegalArgumentException("purported base16 string has illegal char");
            }
            bArr[i / 2] = (byte) ((digit << 4) + digit2);
        }
        return bArr;
    }
}
