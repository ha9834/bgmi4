package com.tencent.gcloud.apkchannel.v1;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes2.dex */
public final class ZipLong implements Cloneable {
    private long value;

    public ZipLong(long j) {
        this.value = j;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        this.value = (bArr[i + 3] << 24) & 4278190080L;
        this.value += (bArr[i + 2] << 16) & 16711680;
        this.value += (bArr[i + 1] << 8) & 65280;
        this.value += bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipLong) && this.value == ((ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        long j = this.value;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }
}
