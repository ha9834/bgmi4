package com.shieldtunnel.svpn.common.i;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class c {
    static {
        ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
    }

    public static String a(byte[] bArr) {
        return (bArr == null || bArr.length != 4) ? "" : String.format(com.shieldtunnel.svpn.common.f.f.b, "%d.%d.%d.%d", Integer.valueOf(bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED), Integer.valueOf(bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED), Integer.valueOf(bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED), Integer.valueOf(bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
    }
}
