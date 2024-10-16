package com.google.android.gms.internal.drive;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzio {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3994a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g = Integer.MAX_VALUE;
    private int h = 64;
    private int i = 67108864;

    private zzio(byte[] bArr, int i, int i2) {
        this.f3994a = bArr;
        this.b = i;
        int i3 = i2 + i;
        this.d = i3;
        this.c = i3;
        this.e = i;
    }

    private final byte a() throws IOException {
        int i = this.e;
        if (i == this.d) {
            throw zziw.a();
        }
        byte[] bArr = this.f3994a;
        this.e = i + 1;
        return bArr[i];
    }

    private final void a(int i) throws IOException {
        if (i < 0) {
            throw zziw.b();
        }
        int i2 = this.e;
        int i3 = i2 + i;
        int i4 = this.g;
        if (i3 > i4) {
            a(i4 - i2);
            throw zziw.a();
        }
        if (i > this.d - i2) {
            throw zziw.a();
        }
        this.e = i2 + i;
    }

    public static zzio zza(byte[] bArr, int i, int i2) {
        return new zzio(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.e - this.b;
    }

    public final String readString() throws IOException {
        int zzbe = zzbe();
        if (zzbe < 0) {
            throw zziw.b();
        }
        int i = this.d;
        int i2 = this.e;
        if (zzbe > i - i2) {
            throw zziw.a();
        }
        String str = new String(this.f3994a, i2, zzbe, zziv.f3999a);
        this.e += zzbe;
        return str;
    }

    public final byte[] zza(int i, int i2) {
        if (i2 == 0) {
            return zzja.zzns;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f3994a, this.b + i, bArr, 0, i2);
        return bArr;
    }

    public final int zzbd() throws IOException {
        if (this.e == this.d) {
            this.f = 0;
            return 0;
        }
        this.f = zzbe();
        int i = this.f;
        if (i != 0) {
            return i;
        }
        throw new zziw("Protocol message contained an invalid tag (zero).");
    }

    public final int zzbe() throws IOException {
        int i;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i2 = a2 & Byte.MAX_VALUE;
        byte a3 = a();
        if (a3 >= 0) {
            i = a3 << 7;
        } else {
            i2 |= (a3 & Byte.MAX_VALUE) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i = a4 << 14;
            } else {
                i2 |= (a4 & Byte.MAX_VALUE) << 14;
                byte a5 = a();
                if (a5 < 0) {
                    int i3 = i2 | ((a5 & Byte.MAX_VALUE) << 21);
                    byte a6 = a();
                    int i4 = i3 | (a6 << 28);
                    if (a6 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (a() >= 0) {
                            return i4;
                        }
                    }
                    throw zziw.c();
                }
                i = a5 << 21;
            }
        }
        return i2 | i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zzbf() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((a() & 128) == 0) {
                return j;
            }
        }
        throw zziw.c();
    }

    public final void zzj(int i) throws zziw {
        if (this.f != i) {
            throw new zziw("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzk(int i) throws IOException {
        int zzbd;
        switch (i & 7) {
            case 0:
                zzbe();
                return true;
            case 1:
                a();
                a();
                a();
                a();
                a();
                a();
                a();
                a();
                return true;
            case 2:
                a(zzbe());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                a();
                a();
                a();
                a();
                return true;
            default:
                throw new zziw("Protocol message tag had invalid wire type.");
        }
        do {
            zzbd = zzbd();
            if (zzbd != 0) {
            }
            zzj(((i >>> 3) << 3) | 4);
            return true;
        } while (zzk(zzbd));
        zzj(((i >>> 3) << 3) | 4);
        return true;
    }
}
