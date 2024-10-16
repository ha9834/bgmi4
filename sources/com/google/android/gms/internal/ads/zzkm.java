package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes2.dex */
public final class zzkm {

    /* renamed from: a, reason: collision with root package name */
    private int f3672a;
    private int b;
    public byte[] data;

    public zzkm() {
    }

    public zzkm(int i) {
        this.data = new byte[i];
        this.b = this.data.length;
    }

    public zzkm(byte[] bArr) {
        this.data = bArr;
        this.b = bArr.length;
    }

    public final void zzb(byte[] bArr, int i) {
        this.data = bArr;
        this.b = i;
        this.f3672a = 0;
    }

    public final int limit() {
        return this.b;
    }

    public final int getPosition() {
        return this.f3672a;
    }

    public final void setPosition(int i) {
        zzkh.checkArgument(i >= 0 && i <= this.b);
        this.f3672a = i;
    }

    public final void zzac(int i) {
        setPosition(this.f3672a + i);
    }

    public final void zzb(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.f3672a, bArr, i, i2);
        this.f3672a += i2;
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.f3672a;
        this.f3672a = i + 1;
        return bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.f3672a;
        this.f3672a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8;
        int i3 = this.f3672a;
        this.f3672a = i3 + 1;
        return (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i2;
    }

    public final long zzge() {
        byte[] bArr = this.data;
        this.f3672a = this.f3672a + 1;
        this.f3672a = this.f3672a + 1;
        long j = ((bArr[r1] & 255) << 24) | ((bArr[r5] & 255) << 16);
        this.f3672a = this.f3672a + 1;
        long j2 = j | ((bArr[r5] & 255) << 8);
        this.f3672a = this.f3672a + 1;
        return j2 | (255 & bArr[r5]);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.f3672a;
        this.f3672a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24;
        int i3 = this.f3672a;
        this.f3672a = i3 + 1;
        int i4 = i2 | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        int i5 = this.f3672a;
        this.f3672a = i5 + 1;
        int i6 = i4 | ((bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
        int i7 = this.f3672a;
        this.f3672a = i7 + 1;
        return (bArr[i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i6;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        this.f3672a = this.f3672a + 1;
        this.f3672a = this.f3672a + 1;
        long j = ((bArr[r1] & 255) << 56) | ((bArr[r5] & 255) << 48);
        this.f3672a = this.f3672a + 1;
        long j2 = j | ((bArr[r5] & 255) << 40);
        this.f3672a = this.f3672a + 1;
        long j3 = j2 | ((bArr[r5] & 255) << 32);
        this.f3672a = this.f3672a + 1;
        long j4 = j3 | ((bArr[r5] & 255) << 24);
        this.f3672a = this.f3672a + 1;
        long j5 = j4 | ((bArr[r5] & 255) << 16);
        this.f3672a = this.f3672a + 1;
        long j6 = j5 | ((bArr[r5] & 255) << 8);
        this.f3672a = this.f3672a + 1;
        return j6 | (255 & bArr[r5]);
    }

    public final int zzgf() {
        byte[] bArr = this.data;
        int i = this.f3672a;
        this.f3672a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8;
        int i3 = this.f3672a;
        this.f3672a = i3 + 1;
        int i4 = (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i2;
        this.f3672a += 2;
        return i4;
    }

    public final int zzgg() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzgh() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new IllegalStateException(sb.toString());
    }
}
