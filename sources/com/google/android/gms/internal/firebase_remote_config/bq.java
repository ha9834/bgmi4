package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bq extends zzgj {
    private final byte[] e;
    private final boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    private bq(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.l = Integer.MAX_VALUE;
        this.e = bArr;
        this.g = i2 + i;
        this.i = i;
        this.j = this.i;
        this.f = z;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfb() throws IOException {
        if (zzfr()) {
            this.k = 0;
            return 0;
        }
        this.k = b();
        int i = this.k;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzhm.d();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final void zzy(int i) throws zzhm {
        if (this.k != i) {
            throw zzhm.e();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final boolean zzz(int i) throws IOException {
        int zzfb;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.g - this.i >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.e;
                        int i3 = this.i;
                        this.i = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzhm.c();
                }
                while (i2 < 10) {
                    if (g() < 0) {
                        i2++;
                    }
                }
                throw zzhm.c();
                return true;
            case 1:
                a(8);
                return true;
            case 2:
                a(b());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                a(4);
                return true;
            default:
                throw zzhm.f();
        }
        do {
            zzfb = zzfb();
            if (zzfb != 0) {
            }
            zzy(((i >>> 3) << 3) | 4);
            return true;
        } while (zzz(zzfb));
        zzy(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(e());
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(d());
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final long zzfc() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final long zzfd() throws IOException {
        return c();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfe() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final long zzff() throws IOException {
        return e();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfg() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final boolean zzfh() throws IOException {
        return c() != 0;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final String readString() throws IOException {
        int b = b();
        if (b > 0) {
            int i = this.g;
            int i2 = this.i;
            if (b <= i - i2) {
                String str = new String(this.e, i2, b, zzhi.f4184a);
                this.i += b;
                return str;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b < 0) {
            throw zzhm.b();
        }
        throw zzhm.a();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final String zzfi() throws IOException {
        int b = b();
        if (b > 0) {
            int i = this.g;
            int i2 = this.i;
            if (b <= i - i2) {
                String b2 = ej.b(this.e, i2, b);
                this.i += b;
                return b2;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b <= 0) {
            throw zzhm.b();
        }
        throw zzhm.a();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final zzfx zzfj() throws IOException {
        byte[] bArr;
        int b = b();
        if (b > 0) {
            int i = this.g;
            int i2 = this.i;
            if (b <= i - i2) {
                zzfx zzb = zzfx.zzb(this.e, i2, b);
                this.i += b;
                return zzb;
            }
        }
        if (b == 0) {
            return zzfx.zzow;
        }
        if (b > 0) {
            int i3 = this.g;
            int i4 = this.i;
            if (b <= i3 - i4) {
                this.i = b + i4;
                bArr = Arrays.copyOfRange(this.e, i4, this.i);
                return zzfx.a(bArr);
            }
        }
        if (b > 0) {
            throw zzhm.a();
        }
        if (b == 0) {
            bArr = zzhi.zzty;
            return zzfx.a(bArr);
        }
        throw zzhm.b();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfk() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfl() throws IOException {
        return b();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfm() throws IOException {
        return d();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final long zzfn() throws IOException {
        return e();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfo() throws IOException {
        return zzac(b());
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final long zzfp() throws IOException {
        return zzg(c());
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
            int r0 = r5.i
            int r1 = r5.g
            if (r1 == r0) goto L6d
            byte[] r2 = r5.e
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.i = r3
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
            r5.i = r1
            return r0
        L6d:
            long r0 = r5.a()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.bq.b():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.bq.c():long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final long a() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((g() & 128) == 0) {
                return j;
            }
        }
        throw zzhm.c();
    }

    private final int d() throws IOException {
        int i = this.i;
        if (this.g - i < 4) {
            throw zzhm.a();
        }
        byte[] bArr = this.e;
        this.i = i + 4;
        return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }

    private final long e() throws IOException {
        int i = this.i;
        if (this.g - i < 8) {
            throw zzhm.a();
        }
        byte[] bArr = this.e;
        this.i = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzaa(int i) throws zzhm {
        if (i < 0) {
            throw zzhm.b();
        }
        int zzfs = i + zzfs();
        int i2 = this.l;
        if (zzfs > i2) {
            throw zzhm.a();
        }
        this.l = zzfs;
        f();
        return i2;
    }

    private final void f() {
        this.g += this.h;
        int i = this.g;
        int i2 = i - this.j;
        int i3 = this.l;
        if (i2 > i3) {
            this.h = i2 - i3;
            this.g = i - this.h;
        } else {
            this.h = 0;
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final void zzab(int i) {
        this.l = i;
        f();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final boolean zzfr() throws IOException {
        return this.i == this.g;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfs() {
        return this.i - this.j;
    }

    private final byte g() throws IOException {
        int i = this.i;
        if (i == this.g) {
            throw zzhm.a();
        }
        byte[] bArr = this.e;
        this.i = i + 1;
        return bArr[i];
    }

    private final void a(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.g;
            int i3 = this.i;
            if (i <= i2 - i3) {
                this.i = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzhm.b();
        }
        throw zzhm.a();
    }
}
