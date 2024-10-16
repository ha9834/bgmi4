package com.tencent.open.utils;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes.dex */
public final class n implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f6413a;

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public n(byte[] bArr, int i) {
        this.f6413a = (bArr[i + 1] << 8) & 65280;
        this.f6413a += bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    public n(int i) {
        this.f6413a = i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.f6413a == ((n) obj).b();
    }

    public byte[] a() {
        int i = this.f6413a;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public int b() {
        return this.f6413a;
    }

    public int hashCode() {
        return this.f6413a;
    }
}
