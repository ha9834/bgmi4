package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzvj extends zzva {
    private MessageDigest b;
    private final int c;
    private final int d;

    public zzvj(int i) {
        int i2 = i / 8;
        this.c = i % 8 > 0 ? i2 + 1 : i2;
        this.d = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzva
    public final byte[] zzbl(String str) {
        synchronized (this.f3757a) {
            this.b = a();
            if (this.b == null) {
                return new byte[0];
            }
            this.b.reset();
            this.b.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = this.b.digest();
            byte[] bArr = new byte[digest.length > this.c ? this.c : digest.length];
            System.arraycopy(digest, 0, bArr, 0, bArr.length);
            if (this.d % 8 > 0) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                }
                long j2 = j >>> (8 - (this.d % 8));
                for (int i2 = this.c - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
