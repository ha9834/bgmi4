package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzis implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final eq f4577a = new eq();
    private boolean b;
    private int[] c;
    private eq[] d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis() {
        this(10);
    }

    private zzis(int i) {
        this.b = false;
        int c = c(i);
        this.c = new int[c];
        this.d = new eq[c];
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final eq a(int i) {
        int d = d(i);
        if (d < 0) {
            return null;
        }
        eq[] eqVarArr = this.d;
        if (eqVarArr[d] == f4577a) {
            return null;
        }
        return eqVarArr[d];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, eq eqVar) {
        int d = d(i);
        if (d >= 0) {
            this.d[d] = eqVar;
            return;
        }
        int i2 = d ^ (-1);
        if (i2 < this.e) {
            eq[] eqVarArr = this.d;
            if (eqVarArr[i2] == f4577a) {
                this.c[i2] = i;
                eqVarArr[i2] = eqVar;
                return;
            }
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int c = c(i3 + 1);
            int[] iArr = new int[c];
            eq[] eqVarArr2 = new eq[c];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            eq[] eqVarArr3 = this.d;
            System.arraycopy(eqVarArr3, 0, eqVarArr2, 0, eqVarArr3.length);
            this.c = iArr;
            this.d = eqVarArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            eq[] eqVarArr4 = this.d;
            System.arraycopy(eqVarArr4, i2, eqVarArr4, i5, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = eqVar;
        this.e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.e;
    }

    public final boolean isEmpty() {
        return this.e == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final eq b(int i) {
        return this.d[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzis)) {
            return false;
        }
        zzis zzisVar = (zzis) obj;
        int i = this.e;
        if (i != zzisVar.e) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = zzisVar.c;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            eq[] eqVarArr = this.d;
            eq[] eqVarArr2 = zzisVar.d;
            int i3 = this.e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!eqVarArr[i4].equals(eqVarArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.e; i2++) {
            i = (((i * 31) + this.c[i2]) * 31) + this.d[i2].hashCode();
        }
        return i;
    }

    private static int c(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int d(int i) {
        int i2 = this.e - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.c[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.e;
        zzis zzisVar = new zzis(i);
        System.arraycopy(this.c, 0, zzisVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            eq[] eqVarArr = this.d;
            if (eqVarArr[i2] != null) {
                zzisVar.d[i2] = (eq) eqVarArr[i2].clone();
            }
        }
        zzisVar.e = i;
        return zzisVar;
    }
}
