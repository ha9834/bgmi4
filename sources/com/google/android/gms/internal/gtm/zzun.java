package com.google.android.gms.internal.gtm;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzun {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f4455a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int i;
    private zzqe l;
    private int h = Integer.MAX_VALUE;
    private int j = 64;
    private int k = 67108864;

    public static zzun zzk(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    public static zzun zzj(byte[] bArr, int i, int i2) {
        return new zzun(bArr, 0, i2);
    }

    public final int zzni() throws IOException {
        if (this.f == this.d) {
            this.g = 0;
            return 0;
        }
        this.g = zzoa();
        int i = this.g;
        if (i != 0) {
            return i;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    public final void zzan(int i) throws zzuv {
        if (this.g != i) {
            throw new zzuv("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzao(int i) throws IOException {
        int zzni;
        switch (i & 7) {
            case 0:
                zzoa();
                return true;
            case 1:
                c();
                c();
                c();
                c();
                c();
                c();
                c();
                c();
                return true;
            case 2:
                a(zzoa());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzoc();
                return true;
            default:
                throw new zzuv("Protocol message tag had invalid wire type.");
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

    public final boolean zzno() throws IOException {
        return zzoa() != 0;
    }

    public final String readString() throws IOException {
        int zzoa = zzoa();
        if (zzoa < 0) {
            throw zzuv.b();
        }
        int i = this.d;
        int i2 = this.f;
        if (zzoa > i - i2) {
            throw zzuv.a();
        }
        String str = new String(this.f4455a, i2, zzoa, zzuu.f4460a);
        this.f += zzoa;
        return str;
    }

    public final void zza(zzuw zzuwVar, int i) throws IOException {
        int i2 = this.i;
        if (i2 >= this.j) {
            throw zzuv.d();
        }
        this.i = i2 + 1;
        zzuwVar.zza(this);
        zzan((i << 3) | 4);
        this.i--;
    }

    public final void zza(zzuw zzuwVar) throws IOException {
        int zzoa = zzoa();
        if (this.i >= this.j) {
            throw zzuv.d();
        }
        int zzaq = zzaq(zzoa);
        this.i++;
        zzuwVar.zza(this);
        zzan(0);
        this.i--;
        zzar(zzaq);
    }

    public final int zzoa() throws IOException {
        byte c = c();
        if (c >= 0) {
            return c;
        }
        int i = c & Byte.MAX_VALUE;
        byte c2 = c();
        if (c2 >= 0) {
            return i | (c2 << 7);
        }
        int i2 = i | ((c2 & Byte.MAX_VALUE) << 7);
        byte c3 = c();
        if (c3 >= 0) {
            return i2 | (c3 << 14);
        }
        int i3 = i2 | ((c3 & Byte.MAX_VALUE) << 14);
        byte c4 = c();
        if (c4 >= 0) {
            return i3 | (c4 << 21);
        }
        int i4 = i3 | ((c4 & Byte.MAX_VALUE) << 21);
        byte c5 = c();
        int i5 = i4 | (c5 << 28);
        if (c5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (c() >= 0) {
                return i5;
            }
        }
        throw zzuv.c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zzob() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((c() & 128) == 0) {
                return j;
            }
        }
        throw zzuv.c();
    }

    public final int zzoc() throws IOException {
        return (c() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((c() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((c() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((c() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24);
    }

    private zzun(byte[] bArr, int i, int i2) {
        this.f4455a = bArr;
        this.b = i;
        int i3 = i2 + i;
        this.d = i3;
        this.c = i3;
        this.f = i;
    }

    private final zzqe a() throws IOException {
        if (this.l == null) {
            this.l = zzqe.zzd(this.f4455a, this.b, this.c);
        }
        int zznz = this.l.zznz();
        int i = this.f - this.b;
        if (zznz > i) {
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(zznz), Integer.valueOf(i)));
        }
        this.l.zzas(i - zznz);
        this.l.zzap(this.j - this.i);
        return this.l;
    }

    public final <T extends zzrc<T, ?>> T zza(zzsu<T> zzsuVar) throws IOException {
        try {
            T t = (T) a().zza(zzsuVar, zzqp.zzor());
            zzao(this.g);
            return t;
        } catch (zzrk e) {
            throw new zzuv("", e);
        }
    }

    public final int zzaq(int i) throws zzuv {
        if (i < 0) {
            throw zzuv.b();
        }
        int i2 = i + this.f;
        int i3 = this.h;
        if (i2 > i3) {
            throw zzuv.a();
        }
        this.h = i2;
        b();
        return i3;
    }

    private final void b() {
        this.d += this.e;
        int i = this.d;
        int i2 = this.h;
        if (i > i2) {
            this.e = i - i2;
            this.d = i - this.e;
        } else {
            this.e = 0;
        }
    }

    public final void zzar(int i) {
        this.h = i;
        b();
    }

    public final int zzrv() {
        int i = this.h;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.f;
    }

    public final int getPosition() {
        return this.f - this.b;
    }

    public final byte[] zzt(int i, int i2) {
        if (i2 == 0) {
            return zzuz.zzbhw;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f4455a, this.b + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzbz(int i) {
        a(i, this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, int i2) {
        int i3 = this.f;
        int i4 = this.b;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.f = i4 + i;
        this.g = i2;
    }

    private final byte c() throws IOException {
        int i = this.f;
        if (i == this.d) {
            throw zzuv.a();
        }
        byte[] bArr = this.f4455a;
        this.f = i + 1;
        return bArr[i];
    }

    private final void a(int i) throws IOException {
        if (i < 0) {
            throw zzuv.b();
        }
        int i2 = this.f;
        int i3 = i2 + i;
        int i4 = this.h;
        if (i3 > i4) {
            a(i4 - i2);
            throw zzuv.a();
        }
        if (i <= this.d - i2) {
            this.f = i2 + i;
            return;
        }
        throw zzuv.a();
    }
}
