package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bp extends zzgj {
    private final InputStream e;
    private final byte[] f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private bs m;

    private bp(InputStream inputStream, int i) {
        super();
        this.l = Integer.MAX_VALUE;
        this.m = null;
        zzhi.a(inputStream, EvaluateItemInfo.ACTIONTYPE_INPUT);
        this.e = inputStream;
        this.f = new byte[i];
        this.g = 0;
        this.i = 0;
        this.k = 0;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfb() throws IOException {
        if (zzfr()) {
            this.j = 0;
            return 0;
        }
        this.j = b();
        int i = this.j;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzhm.d();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final void zzy(int i) throws zzhm {
        if (this.j != i) {
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
                        byte[] bArr = this.f;
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
                e(8);
                return true;
            case 2:
                e(b());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                e(4);
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
                String str = new String(this.f, i2, b, zzhi.f4184a);
                this.i += b;
                return str;
            }
        }
        if (b == 0) {
            return "";
        }
        if (b <= this.g) {
            a(b);
            String str2 = new String(this.f, this.i, b, zzhi.f4184a);
            this.i += b;
            return str2;
        }
        return new String(a(b, false), zzhi.f4184a);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final String zzfi() throws IOException {
        byte[] a2;
        int b = b();
        int i = this.i;
        int i2 = 0;
        if (b <= this.g - i && b > 0) {
            a2 = this.f;
            this.i = i + b;
            i2 = i;
        } else {
            if (b == 0) {
                return "";
            }
            if (b <= this.g) {
                a(b);
                a2 = this.f;
                this.i = b;
            } else {
                a2 = a(b, false);
            }
        }
        return ej.b(a2, i2, b);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final zzfx zzfj() throws IOException {
        int b = b();
        int i = this.g;
        int i2 = this.i;
        if (b <= i - i2 && b > 0) {
            zzfx zzb = zzfx.zzb(this.f, i2, b);
            this.i += b;
            return zzb;
        }
        if (b == 0) {
            return zzfx.zzow;
        }
        byte[] c = c(b);
        if (c != null) {
            return zzfx.zza(c);
        }
        int i3 = this.i;
        int i4 = this.g;
        int i5 = i4 - i3;
        this.k += i4;
        this.i = 0;
        this.g = 0;
        List<byte[]> d = d(b - i5);
        byte[] bArr = new byte[b];
        System.arraycopy(this.f, i3, bArr, 0, i5);
        for (byte[] bArr2 : d) {
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return zzfx.a(bArr);
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
            byte[] r2 = r5.f
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.bp.b():int");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.bp.c():long");
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
            a(4);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 4;
        return ((bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | (bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
    }

    private final long e() throws IOException {
        int i = this.i;
        if (this.g - i < 8) {
            a(8);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzaa(int i) throws zzhm {
        if (i < 0) {
            throw zzhm.b();
        }
        int i2 = i + this.k + this.i;
        int i3 = this.l;
        if (i2 > i3) {
            throw zzhm.a();
        }
        this.l = i2;
        f();
        return i3;
    }

    private final void f() {
        this.g += this.h;
        int i = this.k;
        int i2 = this.g;
        int i3 = i + i2;
        int i4 = this.l;
        if (i3 > i4) {
            this.h = i3 - i4;
            this.g = i2 - this.h;
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
        return this.i == this.g && !b(1);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgj
    public final int zzfs() {
        return this.k + this.i;
    }

    private final void a(int i) throws IOException {
        if (b(i)) {
            return;
        }
        if (i > (this.c - this.k) - this.i) {
            throw zzhm.g();
        }
        throw zzhm.a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean b(int i) throws IOException {
        while (this.i + i > this.g) {
            int i2 = this.c;
            int i3 = this.k;
            int i4 = this.i;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.l) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.g;
                if (i5 > i4) {
                    byte[] bArr = this.f;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.k += i4;
                this.g -= i4;
                this.i = 0;
            }
            InputStream inputStream = this.e;
            byte[] bArr2 = this.f;
            int i6 = this.g;
            int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.c - this.k) - this.g));
            if (read == 0 || read < -1 || read > this.f.length) {
                String valueOf = String.valueOf(this.e.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            }
            if (read <= 0) {
                return false;
            }
            this.g += read;
            f();
            if (this.g >= i) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte g() throws IOException {
        if (this.i == this.g) {
            a(1);
        }
        byte[] bArr = this.f;
        int i = this.i;
        this.i = i + 1;
        return bArr[i];
    }

    private final byte[] a(int i, boolean z) throws IOException {
        byte[] c = c(i);
        if (c != null) {
            return c;
        }
        int i2 = this.i;
        int i3 = this.g;
        int i4 = i3 - i2;
        this.k += i3;
        this.i = 0;
        this.g = 0;
        List<byte[]> d = d(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, i2, bArr, 0, i4);
        for (byte[] bArr2 : d) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] c(int i) throws IOException {
        if (i == 0) {
            return zzhi.zzty;
        }
        if (i < 0) {
            throw zzhm.b();
        }
        int i2 = this.k + this.i + i;
        if (i2 - this.c > 0) {
            throw zzhm.g();
        }
        int i3 = this.l;
        if (i2 > i3) {
            e((i3 - this.k) - this.i);
            throw zzhm.a();
        }
        int i4 = this.g - this.i;
        int i5 = i - i4;
        if (i5 >= 4096 && i5 > this.e.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, this.i, bArr, 0, i4);
        this.k += this.g;
        this.i = 0;
        this.g = 0;
        while (i4 < bArr.length) {
            int read = this.e.read(bArr, i4, i - i4);
            if (read == -1) {
                throw zzhm.a();
            }
            this.k += read;
            i4 += read;
        }
        return bArr;
    }

    private final List<byte[]> d(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.e.read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw zzhm.a();
                }
                this.k += read;
                i2 += read;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void e(int i) throws IOException {
        int i2 = this.g;
        int i3 = this.i;
        if (i <= i2 - i3 && i >= 0) {
            this.i = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzhm.b();
        }
        int i4 = this.k;
        int i5 = this.i;
        int i6 = i4 + i5 + i;
        int i7 = this.l;
        if (i6 > i7) {
            e((i7 - i4) - i5);
            throw zzhm.a();
        }
        this.k = i4 + i5;
        int i8 = this.g - i5;
        this.g = 0;
        this.i = 0;
        while (i8 < i) {
            try {
                long j = i - i8;
                long skip = this.e.skip(j);
                if (skip >= 0 && skip <= j) {
                    if (skip == 0) {
                        break;
                    } else {
                        i8 += (int) skip;
                    }
                } else {
                    String valueOf = String.valueOf(this.e.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                    sb.append(valueOf);
                    sb.append("#skip returned invalid result: ");
                    sb.append(skip);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                }
            } finally {
                this.k += i8;
                f();
            }
        }
        if (i8 >= i) {
            return;
        }
        int i9 = this.g;
        int i10 = i9 - this.i;
        this.i = i9;
        a(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.g;
            if (i11 > i12) {
                i10 += i12;
                this.i = i12;
                a(1);
            } else {
                this.i = i11;
                return;
            }
        }
    }
}
