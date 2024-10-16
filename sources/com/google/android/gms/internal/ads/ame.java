package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;

/* loaded from: classes2.dex */
final class ame {

    /* renamed from: a, reason: collision with root package name */
    private static final long[] f1965a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public final void a() {
        this.c = 0;
        this.d = 0;
    }

    public final long a(zzno zznoVar, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.c == 0) {
            if (!zznoVar.zza(this.b, 0, 1, z)) {
                return -1L;
            }
            this.d = a(this.b[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (this.d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.c = 0;
            return -2L;
        }
        if (i2 != 1) {
            zznoVar.readFully(this.b, 1, i2 - 1);
        }
        this.c = 0;
        return a(this.b, this.d, z2);
    }

    public final int b() {
        return this.d;
    }

    public static int a(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f1965a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & i) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= f1965a[i - 1] ^ (-1);
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }
}
