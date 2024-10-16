package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* loaded from: classes2.dex */
public final class zzsu {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f3738a;
    private int b;
    private int c;
    private int d = 0;

    public zzsu(byte[] bArr, int i, int i2) {
        this.f3738a = bArr;
        this.c = i;
        this.b = i2;
        b();
    }

    public final void zzbq(int i) {
        int i2 = this.c;
        this.c = (i / 8) + i2;
        this.d += i % 8;
        int i3 = this.d;
        if (i3 > 7) {
            this.c++;
            this.d = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.c) {
                if (a(i2)) {
                    this.c++;
                    i2 += 2;
                }
            } else {
                b();
                return;
            }
        }
    }

    public final boolean zzkc() {
        return zzbn(1) == 1;
    }

    public final int zzbn(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        int i3 = i / 8;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = a(this.c + 1) ? this.c + 2 : this.c + 1;
            int i7 = this.d;
            if (i7 != 0) {
                byte[] bArr = this.f3738a;
                i2 = ((bArr[i6] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) >>> (8 - i7)) | ((bArr[this.c] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << i7);
            } else {
                i2 = this.f3738a[this.c];
            }
            i -= 8;
            i4 |= (255 & i2) << i;
            this.c = i6;
        }
        if (i > 0) {
            int i8 = this.d + i;
            byte b = (byte) (255 >> (8 - i));
            int i9 = a(this.c + 1) ? this.c + 2 : this.c + 1;
            if (i8 > 8) {
                byte[] bArr2 = this.f3738a;
                int i10 = (b & (((255 & bArr2[i9]) >> (16 - i8)) | ((bArr2[this.c] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << (i8 - 8)))) | i4;
                this.c = i9;
                i4 = i10;
            } else {
                int i11 = (b & ((255 & this.f3738a[this.c]) >> (8 - i8))) | i4;
                if (i8 == 8) {
                    this.c = i9;
                }
                i4 = i11;
            }
            this.d = i8 % 8;
        }
        b();
        return i4;
    }

    public final int zzkd() {
        return a();
    }

    public final int zzke() {
        int a2 = a();
        return (a2 % 2 == 0 ? -1 : 1) * ((a2 + 1) / 2);
    }

    private final int a() {
        int i = 0;
        while (!zzkc()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zzbn(i) : 0);
    }

    private final boolean a(int i) {
        if (2 > i || i >= this.b) {
            return false;
        }
        byte[] bArr = this.f3738a;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    private final void b() {
        int i;
        int i2;
        int i3 = this.c;
        zzsk.checkState(i3 >= 0 && (i = this.d) >= 0 && i < 8 && (i3 < (i2 = this.b) || (i3 == i2 && i == 0)));
    }
}
