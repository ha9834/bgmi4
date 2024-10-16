package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;

/* loaded from: classes2.dex */
final class akn {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f1935a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public final void a() {
        this.c = 0;
        this.d = 0;
    }

    public final long a(zzie zzieVar, boolean z, boolean z2) throws IOException, InterruptedException {
        if (this.c == 0) {
            if (!zzieVar.zza(this.b, 0, 1, z)) {
                return -1L;
            }
            int i = this.b[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            this.d = -1;
            int i2 = 0;
            while (true) {
                int[] iArr = f1935a;
                if (i2 >= iArr.length) {
                    break;
                }
                if ((iArr[i2] & i) != 0) {
                    this.d = i2 + 1;
                    break;
                }
                i2++;
            }
            if (this.d == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        zzieVar.readFully(this.b, 1, this.d - 1);
        if (z2) {
            byte[] bArr = this.b;
            bArr[0] = (byte) (bArr[0] & (f1935a[this.d - 1] ^ (-1)));
        }
        long j = 0;
        for (int i3 = 0; i3 < this.d; i3++) {
            j = (j << 8) | (this.b[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        }
        this.c = 0;
        return j;
    }

    public final int b() {
        return this.d;
    }
}
