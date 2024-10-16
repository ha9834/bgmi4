package com.tencent.imsdk.android.tools.apkchannel.v2;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes.dex */
public final class ZipShort implements Cloneable {
    private int value;

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        this.value = (bArr[i + 1] << 8) & 65280;
        this.value += bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    public ZipShort(int i) {
        this.value = i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        int i = this.value;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
