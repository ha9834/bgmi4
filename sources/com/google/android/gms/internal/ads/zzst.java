package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes2.dex */
public final class zzst {

    /* renamed from: a, reason: collision with root package name */
    private int f3737a;
    private int b;
    public byte[] data;

    public zzst() {
    }

    public zzst(int i) {
        this.data = new byte[i];
        this.b = i;
    }

    public zzst(byte[] bArr) {
        this.data = bArr;
        this.b = bArr.length;
    }

    public final void reset(int i) {
        zzb(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void zzb(byte[] bArr, int i) {
        this.data = bArr;
        this.b = i;
        this.f3737a = 0;
    }

    public final void reset() {
        this.f3737a = 0;
        this.b = 0;
    }

    public final int zzjz() {
        return this.b - this.f3737a;
    }

    public final int limit() {
        return this.b;
    }

    public final void zzbo(int i) {
        zzsk.checkArgument(i >= 0 && i <= this.data.length);
        this.b = i;
    }

    public final int getPosition() {
        return this.f3737a;
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final void setPosition(int i) {
        zzsk.checkArgument(i >= 0 && i <= this.b);
        this.f3737a = i;
    }

    public final void zzac(int i) {
        setPosition(this.f3737a + i);
    }

    public final void zzb(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.f3737a, bArr, i, i2);
        this.f3737a += i2;
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.f3737a;
        this.f3737a = i + 1;
        return bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.f3737a;
        this.f3737a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8;
        int i3 = this.f3737a;
        this.f3737a = i3 + 1;
        return (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i2;
    }

    public final int zzka() {
        byte[] bArr = this.data;
        int i = this.f3737a;
        this.f3737a = i + 1;
        int i2 = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        int i3 = this.f3737a;
        this.f3737a = i3 + 1;
        return ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | i2;
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i = this.f3737a;
        this.f3737a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8;
        int i3 = this.f3737a;
        this.f3737a = i3 + 1;
        return (short) ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i2);
    }

    public final long zzge() {
        byte[] bArr = this.data;
        this.f3737a = this.f3737a + 1;
        this.f3737a = this.f3737a + 1;
        long j = ((bArr[r1] & 255) << 24) | ((bArr[r5] & 255) << 16);
        this.f3737a = this.f3737a + 1;
        long j2 = j | ((bArr[r5] & 255) << 8);
        this.f3737a = this.f3737a + 1;
        return j2 | (255 & bArr[r5]);
    }

    public final long zzkb() {
        byte[] bArr = this.data;
        this.f3737a = this.f3737a + 1;
        this.f3737a = this.f3737a + 1;
        long j = (bArr[r1] & 255) | ((bArr[r5] & 255) << 8);
        this.f3737a = this.f3737a + 1;
        long j2 = j | ((bArr[r5] & 255) << 16);
        this.f3737a = this.f3737a + 1;
        return j2 | ((255 & bArr[r5]) << 24);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.f3737a;
        this.f3737a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24;
        int i3 = this.f3737a;
        this.f3737a = i3 + 1;
        int i4 = i2 | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
        int i5 = this.f3737a;
        this.f3737a = i5 + 1;
        int i6 = i4 | ((bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
        int i7 = this.f3737a;
        this.f3737a = i7 + 1;
        return (bArr[i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i6;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        this.f3737a = this.f3737a + 1;
        this.f3737a = this.f3737a + 1;
        long j = ((bArr[r1] & 255) << 56) | ((bArr[r5] & 255) << 48);
        this.f3737a = this.f3737a + 1;
        long j2 = j | ((bArr[r5] & 255) << 40);
        this.f3737a = this.f3737a + 1;
        long j3 = j2 | ((bArr[r5] & 255) << 32);
        this.f3737a = this.f3737a + 1;
        long j4 = j3 | ((bArr[r5] & 255) << 24);
        this.f3737a = this.f3737a + 1;
        long j5 = j4 | ((bArr[r5] & 255) << 16);
        this.f3737a = this.f3737a + 1;
        long j6 = j5 | ((bArr[r5] & 255) << 8);
        this.f3737a = this.f3737a + 1;
        return j6 | (255 & bArr[r5]);
    }

    public final int zzgf() {
        byte[] bArr = this.data;
        int i = this.f3737a;
        this.f3737a = i + 1;
        int i2 = (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8;
        int i3 = this.f3737a;
        this.f3737a = i3 + 1;
        int i4 = (bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | i2;
        this.f3737a += 2;
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

    public final String zzbp(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.f3737a + i) - 1;
        String str = new String(this.data, this.f3737a, (i2 >= this.b || this.data[i2] != 0) ? i : i - 1);
        this.f3737a += i;
        return str;
    }
}
