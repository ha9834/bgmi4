package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes2.dex */
public final class zzss {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f3736a;
    private int b;
    private int c;
    private int d;

    public zzss() {
    }

    public zzss(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzss(byte[] bArr, int i) {
        this.f3736a = bArr;
        this.d = i;
    }

    public final int zzbn(int i) {
        int i2;
        int i3;
        int i4;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i5 = i / 8;
        int i6 = i;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = this.c;
            if (i9 != 0) {
                byte[] bArr = this.f3736a;
                int i10 = this.b;
                i4 = ((bArr[i10 + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) >>> (8 - i9)) | ((bArr[i10] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << i9);
            } else {
                i4 = this.f3736a[this.b];
            }
            i6 -= 8;
            i7 |= (255 & i4) << i6;
            this.b++;
        }
        if (i6 > 0) {
            int i11 = this.c + i6;
            byte b = (byte) (255 >> (8 - i6));
            if (i11 > 8) {
                byte[] bArr2 = this.f3736a;
                int i12 = this.b;
                int i13 = (b & (((bArr2[i12 + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) >> (16 - i11)) | ((bArr2[i12] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << (i11 - 8)))) | i7;
                this.b = i12 + 1;
                i7 = i13;
            } else {
                byte[] bArr3 = this.f3736a;
                int i14 = this.b;
                int i15 = (b & ((bArr3[i14] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) >> (8 - i11))) | i7;
                if (i11 == 8) {
                    this.b = i14 + 1;
                }
                i7 = i15;
            }
            this.c = i11 % 8;
        }
        int i16 = this.b;
        if (i16 >= 0 && (i2 = this.c) >= 0 && i2 < 8 && (i16 < (i3 = this.d) || (i16 == i3 && i2 == 0))) {
            z = true;
        }
        zzsk.checkState(z);
        return i7;
    }
}
