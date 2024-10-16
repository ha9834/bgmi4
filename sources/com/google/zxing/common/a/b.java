package com.google.zxing.common.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f5405a;
    private final int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f5405a = aVar;
        int length = iArr.length;
        if (length > 1 && iArr[0] == 0) {
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.b = new int[]{0};
                return;
            }
            this.b = new int[length - i];
            int[] iArr2 = this.b;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        this.b = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        return this.b;
    }

    int b() {
        return this.b.length - 1;
    }

    boolean c() {
        return this.b[0] == 0;
    }

    int a(int i) {
        return this.b[(r0.length - 1) - i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    b a(b bVar) {
        if (!this.f5405a.equals(bVar.f5405a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c()) {
            return bVar;
        }
        if (bVar.c()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = bVar.b;
        if (iArr.length > iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr2.length];
        int length = iArr2.length - iArr.length;
        System.arraycopy(iArr2, 0, iArr3, 0, length);
        for (int i = length; i < iArr2.length; i++) {
            iArr3[i] = a.b(iArr[i - length], iArr2[i]);
        }
        return new b(this.f5405a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public b b(b bVar) {
        if (!this.f5405a.equals(bVar.f5405a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || bVar.c()) {
            return this.f5405a.a();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = bVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = a.b(iArr3[i4], this.f5405a.c(i2, iArr2[i3]));
            }
        }
        return new b(this.f5405a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f5405a.a();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f5405a.c(this.b[i3], i2);
        }
        return new b(this.f5405a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public b[] c(b bVar) {
        if (!this.f5405a.equals(bVar.f5405a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.c()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b a2 = this.f5405a.a();
        int c = this.f5405a.c(bVar.a(bVar.b()));
        b bVar2 = a2;
        b bVar3 = this;
        while (bVar3.b() >= bVar.b() && !bVar3.c()) {
            int b = bVar3.b() - bVar.b();
            int c2 = this.f5405a.c(bVar3.a(bVar3.b()), c);
            b a3 = bVar.a(b, c2);
            bVar2 = bVar2.a(this.f5405a.a(b, c2));
            bVar3 = bVar3.a(a3);
        }
        return new b[]{bVar2, bVar3};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b = b(); b >= 0; b--) {
            int a2 = a(b);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a2 != 1) {
                    int b2 = this.f5405a.b(a2);
                    if (b2 == 0) {
                        sb.append('1');
                    } else if (b2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b2);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b);
                    }
                }
            }
        }
        return sb.toString();
    }
}
