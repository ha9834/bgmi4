package com.subao.common.j;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f6078a = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);

    public static int a(int i) {
        return f6078a ? Integer.reverseBytes(i) : i;
    }

    public static int b(int i) {
        return a(i);
    }

    public static String c(int i) {
        return String.format(com.subao.common.e.r.f6001a, "%d.%d.%d.%d", Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf(i & 255));
    }

    public static String a(byte[] bArr) {
        return (bArr == null || bArr.length != 4) ? "" : String.format(com.subao.common.e.r.f6001a, "%d.%d.%d.%d", Integer.valueOf(bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED), Integer.valueOf(bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED), Integer.valueOf(bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED), Integer.valueOf(bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
    }

    public static byte[] a(String str) {
        if (str == null || str.length() < 7) {
            return null;
        }
        byte[] bArr = new byte[4];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < 4 && i2 < length) {
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt == '.') {
                bArr[i] = (byte) (i3 & 255);
                i++;
                i3 = -1;
            } else {
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
                int i5 = charAt - '0';
                if (i3 != -1) {
                    i5 += i3 * 10;
                }
                if (i5 > 255) {
                    return null;
                }
                i3 = i5;
            }
            i2 = i4;
        }
        if (i != 3 || i3 == -1) {
            return null;
        }
        bArr[3] = (byte) (i3 & 255);
        return bArr;
    }
}
