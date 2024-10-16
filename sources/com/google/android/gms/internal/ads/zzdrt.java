package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdrt implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final aic f3605a = new aic();
    private boolean b;
    private int[] c;
    private aic[] d;
    private int e;

    zzdrt() {
        this(10);
    }

    private zzdrt(int i) {
        this.b = false;
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
        int i5 = i2 / 4;
        this.c = new int[i5];
        this.d = new aic[i5];
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final aic a(int i) {
        return this.d[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdrt)) {
            return false;
        }
        zzdrt zzdrtVar = (zzdrt) obj;
        int i = this.e;
        if (i != zzdrtVar.e) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = zzdrtVar.c;
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
            aic[] aicVarArr = this.d;
            aic[] aicVarArr2 = zzdrtVar.d;
            int i3 = this.e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!aicVarArr[i4].equals(aicVarArr2[i4])) {
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

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.e;
        zzdrt zzdrtVar = new zzdrt(i);
        System.arraycopy(this.c, 0, zzdrtVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            aic[] aicVarArr = this.d;
            if (aicVarArr[i2] != null) {
                zzdrtVar.d[i2] = (aic) aicVarArr[i2].clone();
            }
        }
        zzdrtVar.e = i;
        return zzdrtVar;
    }
}
