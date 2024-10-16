package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f5403a;
    private int b;

    public a() {
        this.b = 0;
        this.f5403a = new int[1];
    }

    public a(int i) {
        this.b = i;
        this.f5403a = c(i);
    }

    a(int[] iArr, int i) {
        this.f5403a = iArr;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return (this.b + 7) / 8;
    }

    private void b(int i) {
        if (i > (this.f5403a.length << 5)) {
            int[] c = c(i);
            int[] iArr = this.f5403a;
            System.arraycopy(iArr, 0, c, 0, iArr.length);
            this.f5403a = c;
        }
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f5403a[i / 32]) != 0;
    }

    public void a(int i, int i2) {
        this.f5403a[i / 32] = i2;
    }

    public void c() {
        int length = this.f5403a.length;
        for (int i = 0; i < length; i++) {
            this.f5403a[i] = 0;
        }
    }

    public void a(boolean z) {
        b(this.b + 1);
        if (z) {
            int[] iArr = this.f5403a;
            int i = this.b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        b(this.b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    public void a(a aVar) {
        int i = aVar.b;
        b(this.b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.a(i2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(a aVar) {
        if (this.b != aVar.b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f5403a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ aVar.f5403a[i];
            i++;
        }
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (a(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i2 + i5] = (byte) i7;
            i5++;
            i4 = i6;
        }
    }

    public int[] d() {
        return this.f5403a;
    }

    public void e() {
        int[] iArr = new int[this.f5403a.length];
        int i = (this.b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.f5403a[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.b;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.f5403a = iArr;
    }

    private static int[] c(int i) {
        return new int[(i + 31) / 32];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && Arrays.equals(this.f5403a, aVar.f5403a);
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.f5403a);
    }

    public String toString() {
        int i = this.b;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f5403a.clone(), this.b);
    }
}
