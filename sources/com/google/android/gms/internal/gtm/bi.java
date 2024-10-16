package com.google.android.gms.internal.gtm;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bi extends zzqe {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private bi(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.k = Integer.MAX_VALUE;
        this.d = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = this.h;
        this.e = z;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzni() throws IOException {
        if (zzny()) {
            this.j = 0;
            return 0;
        }
        this.j = b();
        int i = this.j;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw new zzrk("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzan(int i) throws zzrk {
        if (this.j != i) {
            throw zzrk.d();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzao(int i) throws IOException {
        int zzni;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.f - this.h >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.d;
                        int i3 = this.h;
                        this.h = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzrk.c();
                }
                while (i2 < 10) {
                    if (g() < 0) {
                        i2++;
                    }
                }
                throw zzrk.c();
                return true;
            case 1:
                zzas(8);
                return true;
            case 2:
                zzas(b());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzas(4);
                return true;
            default:
                throw zzrk.e();
        }
        do {
            zzni = zzni();
            if (zzni != 0) {
            }
            zzan(((i >>> 3) << 3) | 4);
            return true;
        } while (zzao(zzni));
        zzan(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(e());
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(d());
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznj() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznk() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznl() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznm() throws IOException {
        return e();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznn() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzno() throws IOException {
        return c() != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final String readString() throws IOException {
        int b = b();
        if (b > 0) {
            int i = this.f;
            int i2 = this.h;
            if (b <= i - i2) {
                String str = new String(this.d, i2, b, zzre.f4443a);
                this.h += b;
                return str;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b < 0) {
            throw zzrk.b();
        }
        throw zzrk.a();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final String zznp() throws IOException {
        int b = b();
        if (b > 0) {
            int i = this.f;
            int i2 = this.h;
            if (b <= i - i2) {
                String b2 = dx.b(this.d, i2, b);
                this.h += b;
                return b2;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b <= 0) {
            throw zzrk.b();
        }
        throw zzrk.a();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final <T extends zzsk> T zza(zzsu<T> zzsuVar, zzqp zzqpVar) throws IOException {
        int b = b();
        if (this.f4433a >= this.b) {
            throw zzrk.f();
        }
        int zzaq = zzaq(b);
        this.f4433a++;
        T zza = zzsuVar.zza(this, zzqpVar);
        zzan(0);
        this.f4433a--;
        zzar(zzaq);
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final zzps zznq() throws IOException {
        byte[] bArr;
        int b = b();
        if (b > 0) {
            int i = this.f;
            int i2 = this.h;
            if (b <= i - i2) {
                zzps zzb = zzps.zzb(this.d, i2, b);
                this.h += b;
                return zzb;
            }
        }
        if (b == 0) {
            return zzps.zzavx;
        }
        if (b > 0) {
            int i3 = this.f;
            int i4 = this.h;
            if (b <= i3 - i4) {
                this.h = b + i4;
                bArr = Arrays.copyOfRange(this.d, i4, this.h);
                return zzps.a(bArr);
            }
        }
        if (b > 0) {
            throw zzrk.a();
        }
        if (b == 0) {
            bArr = zzre.zzbbh;
            return zzps.a(bArr);
        }
        throw zzrk.b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznr() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzns() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznt() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznu() throws IOException {
        return e();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznv() throws IOException {
        int b = b();
        return (-(b & 1)) ^ (b >>> 1);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long zznw() throws IOException {
        long c = c();
        return (-(c & 1)) ^ (c >>> 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int b() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.h
            int r1 = r5.f
            if (r1 == r0) goto L6d
            byte[] r2 = r5.d
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.h = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6d
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L6a
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r3
            goto L6a
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L6a
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L69
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L69
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L69
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6d
            goto L6a
        L69:
            r1 = r3
        L6a:
            r5.h = r1
            return r0
        L6d:
            long r0 = r5.a()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.bi.b():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
    
        if (r2[r0] >= 0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long c() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.bi.c():long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.zzqe
    public final long a() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((g() & 128) == 0) {
                return j;
            }
        }
        throw zzrk.c();
    }

    private final int d() throws IOException {
        int i = this.h;
        if (this.f - i < 4) {
            throw zzrk.a();
        }
        byte[] bArr = this.d;
        this.h = i + 4;
        return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }

    private final long e() throws IOException {
        int i = this.h;
        if (this.f - i < 8) {
            throw zzrk.a();
        }
        byte[] bArr = this.d;
        this.h = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zzaq(int i) throws zzrk {
        if (i < 0) {
            throw zzrk.b();
        }
        int zznz = i + zznz();
        int i2 = this.k;
        if (zznz > i2) {
            throw zzrk.a();
        }
        this.k = zznz;
        f();
        return i2;
    }

    private final void f() {
        this.f += this.g;
        int i = this.f;
        int i2 = i - this.i;
        int i3 = this.k;
        if (i2 > i3) {
            this.g = i2 - i3;
            this.f = i - this.g;
        } else {
            this.g = 0;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzar(int i) {
        this.k = i;
        f();
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final boolean zzny() throws IOException {
        return this.h == this.f;
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final int zznz() {
        return this.h - this.i;
    }

    private final byte g() throws IOException {
        int i = this.h;
        if (i == this.f) {
            throw zzrk.a();
        }
        byte[] bArr = this.d;
        this.h = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzqe
    public final void zzas(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f;
            int i3 = this.h;
            if (i <= i2 - i3) {
                this.h = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzrk.b();
        }
        throw zzrk.a();
    }
}
