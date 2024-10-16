package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
public final class zzus implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final ee f4459a = new ee();
    private boolean b;
    private int[] c;
    private ee[] d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzus() {
        this(10);
    }

    private zzus(int i) {
        this.b = false;
        int c = c(i);
        this.c = new int[c];
        this.d = new ee[c];
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ee a(int i) {
        int d = d(i);
        if (d < 0) {
            return null;
        }
        ee[] eeVarArr = this.d;
        if (eeVarArr[d] == f4459a) {
            return null;
        }
        return eeVarArr[d];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, ee eeVar) {
        int d = d(i);
        if (d >= 0) {
            this.d[d] = eeVar;
            return;
        }
        int i2 = d ^ (-1);
        if (i2 < this.e) {
            ee[] eeVarArr = this.d;
            if (eeVarArr[i2] == f4459a) {
                this.c[i2] = i;
                eeVarArr[i2] = eeVar;
                return;
            }
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int c = c(i3 + 1);
            int[] iArr = new int[c];
            ee[] eeVarArr2 = new ee[c];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            ee[] eeVarArr3 = this.d;
            System.arraycopy(eeVarArr3, 0, eeVarArr2, 0, eeVarArr3.length);
            this.c = iArr;
            this.d = eeVarArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            ee[] eeVarArr4 = this.d;
            System.arraycopy(eeVarArr4, i2, eeVarArr4, i5, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = eeVar;
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
    public final ee b(int i) {
        return this.d[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzus)) {
            return false;
        }
        zzus zzusVar = (zzus) obj;
        int i = this.e;
        if (i != zzusVar.e) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = zzusVar.c;
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
            ee[] eeVarArr = this.d;
            ee[] eeVarArr2 = zzusVar.d;
            int i3 = this.e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!eeVarArr[i4].equals(eeVarArr2[i4])) {
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
        zzus zzusVar = new zzus(i);
        System.arraycopy(this.c, 0, zzusVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            ee[] eeVarArr = this.d;
            if (eeVarArr[i2] != null) {
                zzusVar.d[i2] = (ee) eeVarArr[i2].clone();
            }
        }
        zzusVar.e = i;
        return zzusVar;
    }
}
