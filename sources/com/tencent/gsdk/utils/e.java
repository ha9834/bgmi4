package com.tencent.gsdk.utils;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.util.UUID;

/* loaded from: classes2.dex */
public class e {
    public static byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static int a(byte[] bArr) {
        return ((bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }

    public static String a() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
