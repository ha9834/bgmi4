package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f5408a;
    private final int b;
    private final int c;
    private final byte[] d;

    public e(CharSequence charSequence, int i, int i2) {
        this.f5408a = charSequence;
        this.c = i;
        this.b = i2;
        this.d = new byte[i * i2];
        Arrays.fill(this.d, (byte) -1);
    }

    public final boolean a(int i, int i2) {
        return this.d[(i2 * this.c) + i] == 1;
    }

    private void a(int i, int i2, boolean z) {
        this.d[(i2 * this.c) + i] = z ? (byte) 1 : (byte) 0;
    }

    private boolean b(int i, int i2) {
        return this.d[(i2 * this.c) + i] >= 0;
    }

    public final void a() {
        int i;
        int i2;
        int i3 = 4;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 == this.b && i4 == 0) {
                a(i5);
                i5++;
            }
            if (i3 == this.b - 2 && i4 == 0 && this.c % 4 != 0) {
                b(i5);
                i5++;
            }
            if (i3 == this.b - 2 && i4 == 0 && this.c % 8 == 4) {
                c(i5);
                i5++;
            }
            if (i3 == this.b + 4 && i4 == 2 && this.c % 8 == 0) {
                d(i5);
                i5++;
            }
            do {
                if (i3 < this.b && i4 >= 0 && !b(i4, i3)) {
                    a(i3, i4, i5);
                    i5++;
                }
                i3 -= 2;
                i4 += 2;
                if (i3 < 0) {
                    break;
                }
            } while (i4 < this.c);
            int i6 = i3 + 1;
            int i7 = i4 + 3;
            do {
                if (i6 >= 0 && i7 < this.c && !b(i7, i6)) {
                    a(i6, i7, i5);
                    i5++;
                }
                i6 += 2;
                i7 -= 2;
                if (i6 >= this.b) {
                    break;
                }
            } while (i7 >= 0);
            i3 = i6 + 3;
            i4 = i7 + 1;
            i = this.b;
            if (i3 >= i && i4 >= (i2 = this.c)) {
                break;
            }
        }
        if (b(i2 - 1, i - 1)) {
            return;
        }
        a(this.c - 1, this.b - 1, true);
        a(this.c - 2, this.b - 2, true);
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.c;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        a(i2, i, (this.f5408a.charAt(i3) & (1 << (8 - i4))) != 0);
    }

    private void a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        a(i4, i6, i3, 2);
        int i7 = i - 1;
        a(i7, i5, i3, 3);
        a(i7, i6, i3, 4);
        a(i7, i2, i3, 5);
        a(i, i5, i3, 6);
        a(i, i6, i3, 7);
        a(i, i2, i3, 8);
    }

    private void a(int i) {
        a(this.b - 1, 0, i, 1);
        a(this.b - 1, 1, i, 2);
        a(this.b - 1, 2, i, 3);
        a(0, this.c - 2, i, 4);
        a(0, this.c - 1, i, 5);
        a(1, this.c - 1, i, 6);
        a(2, this.c - 1, i, 7);
        a(3, this.c - 1, i, 8);
    }

    private void b(int i) {
        a(this.b - 3, 0, i, 1);
        a(this.b - 2, 0, i, 2);
        a(this.b - 1, 0, i, 3);
        a(0, this.c - 4, i, 4);
        a(0, this.c - 3, i, 5);
        a(0, this.c - 2, i, 6);
        a(0, this.c - 1, i, 7);
        a(1, this.c - 1, i, 8);
    }

    private void c(int i) {
        a(this.b - 3, 0, i, 1);
        a(this.b - 2, 0, i, 2);
        a(this.b - 1, 0, i, 3);
        a(0, this.c - 2, i, 4);
        a(0, this.c - 1, i, 5);
        a(1, this.c - 1, i, 6);
        a(2, this.c - 1, i, 7);
        a(3, this.c - 1, i, 8);
    }

    private void d(int i) {
        a(this.b - 1, 0, i, 1);
        a(this.b - 1, this.c - 1, i, 2);
        a(0, this.c - 3, i, 3);
        a(0, this.c - 2, i, 4);
        a(0, this.c - 1, i, 5);
        a(1, this.c - 3, i, 6);
        a(1, this.c - 2, i, 7);
        a(1, this.c - 1, i, 8);
    }
}
