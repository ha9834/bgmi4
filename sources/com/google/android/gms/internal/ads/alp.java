package com.google.android.gms.internal.ads;

import com.google.android.gms.games.GamesStatusCodes;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class alp {

    /* renamed from: a, reason: collision with root package name */
    private final int f1958a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final short[] f;
    private int g;
    private short[] h;
    private int i;
    private short[] j;
    private int k;
    private short[] l;
    private int m;
    private int n;
    private float o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;

    public alp(int i, int i2) {
        this.f1958a = i;
        this.b = i2;
        this.c = i / 400;
        this.d = i / 65;
        this.e = this.d * 2;
        int i3 = this.e;
        this.f = new short[i3];
        this.g = i3;
        this.h = new short[i3 * i2];
        this.i = i3;
        this.j = new short[i3 * i2];
        this.k = i3;
        this.l = new short[i3 * i2];
        this.m = 0;
        this.n = 0;
        this.u = 0;
        this.o = 1.0f;
        this.p = 1.0f;
    }

    public final void a(float f) {
        this.o = f;
    }

    public final void b(float f) {
        this.p = f;
    }

    public final void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.b;
        int i2 = remaining / i;
        b(i2);
        shortBuffer.get(this.h, this.q * this.b, ((i * i2) << 1) / 2);
        this.q += i2;
        c();
    }

    public final void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.b, this.r);
        shortBuffer.put(this.j, 0, this.b * min);
        this.r -= min;
        short[] sArr = this.j;
        int i = this.b;
        System.arraycopy(sArr, min * i, sArr, 0, this.r * i);
    }

    public final void a() {
        int i;
        int i2 = this.q;
        float f = this.o;
        float f2 = this.p;
        int i3 = this.r + ((int) ((((i2 / (f / f2)) + this.s) / f2) + 0.5f));
        b((this.e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.e;
            int i5 = this.b;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.h[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.q += i * 2;
        c();
        if (this.r > i3) {
            this.r = i3;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    public final int b() {
        return this.r;
    }

    private final void a(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        if (i2 > i3) {
            this.i = i3 + (i3 / 2) + i;
            this.j = Arrays.copyOf(this.j, this.i * this.b);
        }
    }

    private final void b(int i) {
        int i2 = this.q + i;
        int i3 = this.g;
        if (i2 > i3) {
            this.g = i3 + (i3 / 2) + i;
            this.h = Arrays.copyOf(this.h, this.g * this.b);
        }
    }

    private final void a(short[] sArr, int i, int i2) {
        a(i2);
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, this.j, this.r * i3, i3 * i2);
        this.r += i2;
    }

    private final void b(short[] sArr, int i, int i2) {
        int i3 = this.e / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f[i7] = (short) (i8 / i5);
        }
    }

    private final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.w = i5 / i6;
        this.x = i7 / i8;
        return i6;
    }

    private final void c() {
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.r;
        float f = this.o / this.p;
        double d = f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.q;
            if (i9 >= this.e) {
                int i10 = 0;
                while (true) {
                    int i11 = this.t;
                    if (i11 > 0) {
                        int min = Math.min(this.e, i11);
                        a(this.h, i10, min);
                        this.t -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.h;
                        int i12 = this.f1958a;
                        int i13 = i12 > 4000 ? i12 / GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND : 1;
                        if (this.b == i8 && i13 == i8) {
                            i = a(sArr, i10, this.c, this.d);
                        } else {
                            b(sArr, i10, i13);
                            int a2 = a(this.f, 0, this.c / i13, this.d / i13);
                            if (i13 != i8) {
                                int i14 = a2 * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.c;
                                if (i16 >= i18) {
                                    i18 = i16;
                                }
                                int i19 = this.d;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.b == i8) {
                                    i = a(sArr, i10, i18, i17);
                                } else {
                                    b(sArr, i10, i8);
                                    i = a(this.f, 0, i18, i17);
                                }
                            } else {
                                i = a2;
                            }
                        }
                        int i20 = this.w;
                        int i21 = this.x;
                        if (i20 == 0 || this.u == 0) {
                            z = false;
                        } else if (i21 > i20 * 3) {
                            z = false;
                        } else {
                            z = (i20 << 1) > this.v * 3;
                        }
                        int i22 = z ? this.u : i;
                        this.v = this.w;
                        this.u = i;
                        if (d > 1.0d) {
                            short[] sArr2 = this.h;
                            if (f >= 2.0f) {
                                i3 = (int) (i22 / (f - 1.0f));
                            } else {
                                this.t = (int) ((i22 * (2.0f - f)) / (f - 1.0f));
                                i3 = i22;
                            }
                            a(i3);
                            int i23 = i3;
                            a(i3, this.b, this.j, this.r, sArr2, i10, sArr2, i10 + i22);
                            this.r += i23;
                            i10 += i22 + i23;
                        } else {
                            int i24 = i22;
                            short[] sArr3 = this.h;
                            if (f < 0.5f) {
                                i2 = (int) ((i24 * f) / (1.0f - f));
                            } else {
                                this.t = (int) ((i24 * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i2 = i24;
                            }
                            int i25 = i24 + i2;
                            a(i25);
                            int i26 = this.b;
                            System.arraycopy(sArr3, i10 * i26, this.j, this.r * i26, i26 * i24);
                            a(i2, this.b, this.j, this.r + i24, sArr3, i24 + i10, sArr3, i10);
                            this.r += i25;
                            i10 += i2;
                        }
                    }
                    if (this.e + i10 > i9) {
                        break;
                    } else {
                        i8 = 1;
                    }
                }
                int i27 = this.q - i10;
                short[] sArr4 = this.h;
                int i28 = this.b;
                System.arraycopy(sArr4, i10 * i28, sArr4, 0, i28 * i27);
                this.q = i27;
            }
        } else {
            a(this.h, 0, this.q);
            this.q = 0;
        }
        float f2 = this.p;
        if (f2 == 1.0f || this.r == i7) {
            return;
        }
        int i29 = this.f1958a;
        int i30 = (int) (i29 / f2);
        while (true) {
            if (i30 <= 16384 && i29 <= 16384) {
                break;
            }
            i30 /= 2;
            i29 /= 2;
        }
        int i31 = this.r - i7;
        int i32 = this.s + i31;
        int i33 = this.k;
        if (i32 > i33) {
            this.k = i33 + (i33 / 2) + i31;
            this.l = Arrays.copyOf(this.l, this.k * this.b);
        }
        short[] sArr5 = this.j;
        int i34 = this.b;
        System.arraycopy(sArr5, i7 * i34, this.l, this.s * i34, i34 * i31);
        this.r = i7;
        this.s += i31;
        int i35 = 0;
        while (true) {
            i4 = this.s;
            if (i35 >= i4 - 1) {
                break;
            }
            while (true) {
                i5 = this.m;
                int i36 = (i5 + 1) * i30;
                i6 = this.n;
                if (i36 <= i6 * i29) {
                    break;
                }
                a(1);
                int i37 = 0;
                while (true) {
                    int i38 = this.b;
                    if (i37 < i38) {
                        short[] sArr6 = this.j;
                        int i39 = (this.r * i38) + i37;
                        short[] sArr7 = this.l;
                        int i40 = (i35 * i38) + i37;
                        short s = sArr7[i40];
                        short s2 = sArr7[i40 + i38];
                        int i41 = this.n * i29;
                        int i42 = this.m;
                        int i43 = i42 * i30;
                        int i44 = (i42 + 1) * i30;
                        int i45 = i44 - i41;
                        int i46 = i44 - i43;
                        sArr6[i39] = (short) (((s * i45) + ((i46 - i45) * s2)) / i46);
                        i37++;
                    }
                }
                this.n++;
                this.r++;
            }
            this.m = i5 + 1;
            if (this.m == i29) {
                this.m = 0;
                zzsk.checkState(i6 == i30);
                this.n = 0;
            }
            i35++;
        }
        int i47 = i4 - 1;
        if (i47 != 0) {
            short[] sArr8 = this.l;
            int i48 = this.b;
            System.arraycopy(sArr8, i47 * i48, sArr8, 0, (i4 - i47) * i48);
            this.s -= i47;
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
